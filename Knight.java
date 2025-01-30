import java.util.Vector;

public class Knight {
    public String color;
    public int[] translatedArrayPosition = new int[2];
    public String letters = "abcdefgh";
    public String numbers = "87654321";

    public boolean inBounds(int[] coordinate){
        int indexOne = coordinate[0];
        int indexTwo = coordinate[1];
        if(indexOne < 0 || indexOne > 7) return false;
        if(indexTwo < 0 || indexTwo > 7) return false;
        return true;
    }

    public void generateCoordinates() {

        // Vector<int[]> vector = new Vector<>();

        int indexOne = translatedArrayPosition[0];
        int indexTwo = translatedArrayPosition[1];

        int[] topLeft = { indexOne - 2, indexTwo - 1 };
        int[] topRight = { indexOne - 2, indexTwo + 1 };

        int[] leftTop = { indexOne - 1, indexTwo - 2 };
        int[] leftBottom = { indexOne + 1, indexTwo - 2 };

        int[] rightTop = { indexOne - 1, indexTwo + 2 };
        int[] rightBottom = { indexOne + 1, indexTwo + 2 };

        int[] bottomLeft = { indexOne + 2, indexTwo - 1 };
        int[] bottomRight = { indexOne + 2, indexTwo + 1 };

       

    }

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