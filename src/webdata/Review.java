package webdata;

import java.util.ArrayList;

public class Review {
//    product/productId: B001E4KFG0
//    review/userId: A3SGXH7AUHU8GW
//    review/profileName: delmartian
//    review/helpfulness: 1/1
//    review/score: 5.0
//    review/time: 1303862400
//    review/summary: Good Quality Dog Food
//    review/text:
    private String productId;
    private String userId;
    private String profileName;
    private String helpfulness;
    private String score;
    private String time;
    private String summary;
    private String text;
    private int id;


    public Review(String productId,String userId,String profileName,String
            helpfulness,
                  String score,String time,
                  String summary,int id){
        this.helpfulness = helpfulness;
        this.productId = productId;
        this.userId = userId;
        this.profileName = profileName;
        this.score = score;
        this.time = time;
        this.summary = summary;
        this.id = id;
    }
    public Review(ArrayList<String> start_review,int id){
        this.productId = start_review.get(0);
        this.userId =  start_review.get(1);
        this.profileName =  start_review.get(2);
        this.helpfulness =  start_review.get(3);
        this.score =  start_review.get(4);
        this.time =  start_review.get(5);
        this.summary =  start_review.get(6);
        this.text =  start_review.get(7);

    }

    @Override
    public String toString() {
        String str = "";
        str = "prodect id "+this.productId+" user "+this.userId+" prof name " +
                ""+this.profileName+" score "+this.score+" time "+this.time+"" +
                " text "+this.text;
        return str;
    }
}
