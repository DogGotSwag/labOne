public class Knight {
    public String color;
    public int[] translatedArrayPosition = new int[2];
    public String letters = "abcdefgh";
    public String numbers = "87654321";

    // public void generateCoordinates(){

    //     int indexOne = translatedArrayPosition[0];
    //     int indexTwo = translatedArrayPosition[1];

    //     System.out.println(indexOne);

    //     int[] topOne = {indexOne, indexTwo};
    //     System.out.print(topOne[0]+", ");
    //     System.out.print(topOne[1]);
    //     System.out.println();
    // }

    public Knight(String color, String position) {
        this.color = color;
        translatedArrayPosition[1] = letters.indexOf(position.split("")[0]);
        translatedArrayPosition[0] = numbers.indexOf(position.split("")[1]);
    }

    public static void main(String[] args) {
        Knight test = new Knight("red", "g1");
        test.generateCoordinates();
    }
}