import java.util.Vector;

//Author: Didier A.L

public class Queen { // change class name
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
        // use vector.add() to add individual coordinate arrays into vector
        // see Knight.java to see it in action
        // u can use inbounds method to check if a coordinate is valid

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
        return vectorToArray(vector);
    }

    // constructor
    public Queen(String color, String position) { // change to class name
        this.color = color.toLowerCase();
        this.position = position.toLowerCase();
        this.availableCoordinates = generateCoordinates();
    }

    // main will be used test your available coordinates output
    public static void main(String[] args) {
        Queen test = new Queen("red", "e4"); // change to class name
        // System.out.println(test.color);
        // System.out.println(test.position);
        int[][] arr = test.availableCoordinates;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + ", " + arr[i][1]);
        }
    }
}