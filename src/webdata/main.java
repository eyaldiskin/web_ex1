package webdata;

public class main {
    public static void main(String[] args) {
        String input_file = "C:\\Users\\aya " +
                "bernstine\\Documents\\aichzor_mida\\100.txt";
        String dir = "";
        SlowIndexWriter writer = new SlowIndexWriter();
        writer.slowWrite(input_file, dir);
    }
}
