public class Knight {
    public String color;
    public int[] translatedArrayPosition = new int[2];

    public String letters = "abcdefgh";
    public String numbers = "87654321";

    public Knight(String color, String position) {
        this.color = color;
        translatedArrayPosition[0] = letters.indexOf(position.split("")[0]);
        translatedArrayPosition[1] = numbers.indexOf(position.split("")[1]);
    }

    public static void main(String[] args) {
        Knight test = new Knight("red", "g3");
        System.out.println(test.translatedArrayPosition[0]);
        System.out.println(test.translatedArrayPosition[1]);
    }
}