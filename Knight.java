import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class Knight {
    public String color;
    public String position;
    public int[][] availableCoordinates;

    public String letters = "abcdefgh";
    public String numbers = "87654321";

    public boolean inBounds(int[] coordinate) {
        int indexOne = coordinate[0];
        int indexTwo = coordinate[1];
        if (indexOne < 0 || indexOne > 7)
            return false;
        if (indexTwo < 0 || indexTwo > 7)
            return false;
        return true;
    }

    public int[][] vectorToArray(Vector<int[]> vector) {
        int[][] newArray = new int[vector.size()][2];
        for (int i = 0; i < vector.size(); i += 1) {
            int[] curr = { vector.get(i)[0], vector.get(i)[1] };
            newArray[i] = curr;
        }
        return newArray;
    }

    public int[][] generateCoordinates() {
        int[] translatedArrayPosition = new int[2];
        translatedArrayPosition[1] = letters.indexOf(position.split("")[0]);
        translatedArrayPosition[0] = numbers.indexOf(position.split("")[1]);

        Vector<int[]> vector = new Vector<>();

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

        if (inBounds(topLeft) == true)
            vector.add(topLeft);
        if (inBounds(topRight) == true)
            vector.add(topRight);
        if (inBounds(leftTop) == true)
            vector.add(leftTop);
        if (inBounds(leftBottom) == true)
            vector.add(leftBottom);
        if (inBounds(rightTop) == true)
            vector.add(rightTop);
        if (inBounds(rightBottom) == true)
            vector.add(rightBottom);
        if (inBounds(bottomLeft) == true)
            vector.add(bottomLeft);
        if (inBounds(bottomRight) == true)
            vector.add(bottomRight);

        return vectorToArray(vector);
    }

    public Knight(String color, String position) {
        this.color = color;
        this.position = position;
        this.availableCoordinates = generateCoordinates();
    }

    public static void main(String[] args) {
        Knight test = new Knight("red", "g8");
        System.out.println(test.color);
        System.out.println(test.position);
        int[][] arr = test.availableCoordinates;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]+", "+arr[i][1]);
        }
    }
}