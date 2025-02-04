import java.util.Scanner;
import java.io.File;
import java.util.Vector;


//Author: Didier Longoria & Yahir Zapata

public class Piece {
    public String color;
    public String position;
    public int[][] availableCoordinates;

    public Piece(String color, String position) {
        this.color = color.toLowerCase();
        this.position = position.toLowerCase();
    }
}

public class txttoarr {
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

    public static void main (String [] args) throws Exception {

        File Pieces = new File ("./input.txt");
        Scanner scanner = new Scanner(Pieces);
        Vector<String> vector = new Vector<>();

        while (scanner.hasNextLine()) {
            String textLine = scanner.nextLine();
            vector.add(textLine);
        }
        scanner.close();
        Scanner getCoordinate = new Scanner(System.in);
        System.out.print("Attack Position: ");
        String attackPosition = getCoordinate.nextLine();


        for (int i = 0; i < vector.size(); i++) {
            // String[] info = vector.get(i).split(", ");
            // String type = info[0];
            // String color = info[1];
            // String position = info[2]+""+info[3];
            // System.out.println(type);
            // System.out.println(color);
            // System.out.println(position);
            // System.out.println("--------");

            Piece temp = new Piece("white", "E4" );
            // temp.availableCoordinates = method();
            
        }

    }

}