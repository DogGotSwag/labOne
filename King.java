import java.util.Vector;

public class King { // change class name
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

        int[] top = { rows - 1, cols };
        int[] topLeft = { rows - 1, cols - 1 };
        int[] topRight = { rows - 1, cols + 1 };

        int[] left = { rows, cols - 1 };
        int[] right = { rows, cols + 1 };

        int[] bottom = { rows + 1, cols };
        int[] bottomLeft = { rows + 1, cols - 1 };
        int[] bottomRight = { rows + 1, cols + 1 };

        if (inBounds(top))
            vector.add(top);
        if (inBounds(topLeft))
            vector.add(topLeft);
        if (inBounds(topRight))
            vector.add(topRight);
        if (inBounds(left))
            vector.add(left);
        if (inBounds(right))
            vector.add(right);
        if (inBounds(bottom))
            vector.add(bottom);
        if (inBounds(bottomLeft))
            vector.add(bottomLeft);
        if (inBounds(bottomRight))
            vector.add(bottomRight);

        return vectorToArray(vector);
    }

    public King(String color, String position) { // change to class name
        this.color = color.toLowerCase();
        this.position = position.toLowerCase();
        this.availableCoordinates = generateCoordinates();
    }

}