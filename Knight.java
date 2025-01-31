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
        Vector<int[]> vector = new Vector<>();
        int rows = numbers.indexOf(position.split("")[1]);
        int cols = letters.indexOf(position.split("")[0]);

        int[] topLeft = { rows - 2, cols - 1 };
        int[] topRight = { rows - 2, cols + 1 };

        int[] leftTop = { rows - 1, cols - 2 };
        int[] leftBottom = { rows + 1, cols - 2 };

        int[] rightTop = { rows - 1, cols + 2 };
        int[] rightBottom = { rows + 1, cols + 2 };

        int[] bottomLeft = { rows + 2, cols - 1 };
        int[] bottomRight = { rows + 2, cols + 1 };

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
        this.color = color.toLowerCase();
        this.position = position.toLowerCase();
        this.availableCoordinates = generateCoordinates();
    }

    public static void main(String[] args) {
        Knight test = new Knight("red", "g1"); // change to class name
        int[][] arr = test.availableCoordinates;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + ", " + arr[i][1]);
        }
    }
}