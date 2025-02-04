import java.util.Vector;

public class Pawn {
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
        String col = "abcdefgh";
        String row = "87654321";

        int rows = row.indexOf(position.charAt(1));
        int cols = col.indexOf(position.charAt(0));

        int direction = (color.equals("white")) ? -1 : 1;

        // Forward move
        int[] forwardMove = { rows + direction, cols };
        if (inBounds(forwardMove)) {
            vector.add(forwardMove);
        }

        return vectorToArray(vector);
    }

    // constructor
    public Pawn(String color, String position) {
        this.color = color.toLowerCase();
        this.position = position.toLowerCase();
        this.availableCoordinates = generateCoordinates();
    }

    // main will be used test your available coordinates output
    public static void main(String[] args) {
        Pawn test = new Pawn("white", "g2");
        System.out.println(test.color);
        System.out.println(test.position);
        int[][] arr = test.availableCoordinates;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + ", " + arr[i][1]);
        }
    }
}