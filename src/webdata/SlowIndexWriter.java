package webdata;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SlowIndexWriter {
    /**
     * Given product review data, creates an on disk index
     * inputFile is the path to the file containing the review data
     * dir is the directory in which all index files will be created
     * if the directory does not exist, it should be created
     */
    public void slowWrite(String inputFile, String dir) {
        try {
            File myObj = new File(inputFile);
            Scanner myReader = new Scanner(myObj);
            ArrayList<Review> all_reviews = new ArrayList<Review>();
            int reviews_num =0;
            int num_field=0;
            String text = "";
            ArrayList<String> review_info = new ArrayList<String>();
            int id =1;
            while (myReader.hasNextLine()) {
                if (num_field<=7){
                    String data = myReader.nextLine();
                    String pattern = "[\\S\\s]?:\\s*(.*)";

                    // Create a Pattern object
                    Pattern r = Pattern.compile(pattern);

                    // Now create matcher object.
                    Matcher m = r.matcher(data);
                    if (m.find()){
                        review_info.add(m.group(1));
                        num_field+=1;
                    }
                    else{
                        System.out.println("something not good");
                    }
                }
                else if(num_field == 8)
                {
                    String data = myReader.nextLine();
                    if (data.contains("product/productId"))
                    {
                        num_field =0;
                        review_info.add(text);
                        System.out.println(review_info.size());
                        Review review  = new Review(review_info,id);
                        id+=1;
                        all_reviews.add(review);
                        review_info.clear();
                        text = "";
                        String pattern = "[\\S\\s]?:\\s*(.*)";

                        // Create a Pattern object
                        Pattern r = Pattern.compile(pattern);

                        // Now create matcher object.
                        Matcher m = r.matcher(data);
                        if (m.find()){
                            review_info.add(m.group(1));
                            num_field+=1;
                        }
                    }
                    else {
                        text+=" "+data;
                    }
                }
            }
            for (Review review : all_reviews)
            {
                System.out.println(review);
            }

            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error on file open occurred.");
            e.printStackTrace();
        }

    }

    /**
     * Delete all index files by removing the given directory
     */
    public void removeIndex(String dir) {}
}



