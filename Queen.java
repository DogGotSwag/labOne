import java.util.Vector;

//Author: Didier A.L

public class Queen {
    public String color;
    public String position;
    public int[][] availableCoordinates;

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
        Vector<int[]> vector = new Vector<>();

        String letters = "abcdefgh";
        String numbers = "87654321";

        int rows = numbers.indexOf(position.split("")[1]);
        int cols = letters.indexOf(position.split("")[0]);

        for (int i = cols - 1; i >= 0; i -= 1) {
            int[] left = { rows, i };
            vector.add(left);
        }
        for (int i = cols + 1; i <= 7; i += 1) {
            int[] right = { rows, i };
            vector.add(right);
        }
        for (int i = rows - 1; i >= 0; i -= 1) {
            int[] up = { i, cols };
            vector.add(up);
        }
        for (int i = rows + 1; i <= 7; i += 1) {
            int[] down = { i, cols };
            vector.add(down);
        }

        int copyRows = rows - 1;
        int copyCols = cols + 1;
        while (copyRows >= 0 && copyCols <= 7) {
            int[] topRight = { copyRows, copyCols };
            vector.add(topRight);
            copyRows -= 1;
            copyCols += 1;
        }

        copyRows = rows - 1;
        copyCols = cols - 1;
        while (copyRows >= 0 && copyCols >= 0) {
            int[] topLeft = { copyRows, copyCols };
            vector.add(topLeft);
            copyRows -= 1;
            copyCols -= 1;
        }

        copyRows = rows + 1;
        copyCols = cols - 1;
        while (copyRows <= 7 && copyCols >= 0) {
            int[] bottomLeft = { copyRows, copyCols };
            vector.add(bottomLeft);
            copyRows += 1;
            copyCols -= 1;
        }

        copyRows = rows + 1;
        copyCols = cols + 1;
        while (copyRows <= 7 && copyCols <= 7) {
            int[] bottomRight = { copyRows, copyCols };
            vector.add(bottomRight);
            copyRows += 1;
            copyCols += 1;
        }

        return vectorToArray(vector);
    }

    public Queen(String color, String position) {
        this.color = color.toLowerCase();
        this.position = position.toLowerCase();
        this.availableCoordinates = generateCoordinates();
    }

    public static void main(String[] args) {
        Queen test = new Queen("red", "e4");
        // System.out.println(test.color);
        // System.out.println(test.position);
        int[][] arr = test.availableCoordinates;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + ", " + arr[i][1]);
        }
    }
}