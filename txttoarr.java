import java.util.Scanner;
import java.io.File;
import java.util.Vector;


//Author: Didier Longoria & Yahir Zapata

public class txttoarr {

    public static String columns = "abcdefgh";
    public static String rows = "87654321";
    
    public static boolean inBounds(int[] coordinate) {
        int indexOne = coordinate[0];
        int indexTwo = coordinate[1];
        if (indexOne < 0 || indexOne > 7)
            return false;
        if (indexTwo < 0 || indexTwo > 7)
            return false;
        return true;
    }

    public static int[][] vectorToArray(Vector<int[]> vector) {
        int[][] newArray = new int[vector.size()][2];
        for (int i = 0; i < vector.size(); i += 1) {
            int[] curr = { vector.get(i)[0], vector.get(i)[1] };
            newArray[i] = curr;
        }
        return newArray;
    }

    public static int[][] generateBishopCoordinates(String position) {
        Vector<int[]> vector = new Vector<>();
        int indexOne = rows.indexOf(position.split("")[1]);
        int indexTwo = columns.indexOf(position.split("")[0]);
        // use vector.add() to add individual coordinate arrays into vector
        // see Knight.java to see it in action  
        //u can use inbounds method to check if a coordinate is valid

        /*
         * code here :]
         * happy coding
         */
        
        //Top Left
        int x = indexOne;
        int y = indexTwo;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x + 1;
            y = y - 1;

            int [] topLeft = {x, y};

            if (inBounds(topLeft) == true)
            vector.add(topLeft);

        }

        //Top Right
        x = indexOne;
        y = indexTwo;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x + 1;
            y = y + 1;

            int [] topRight = {x, y};

            if (inBounds(topRight) == true)
            vector.add(topRight);

        }

        //Bottom Left
        x = indexOne;
        y = indexTwo;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x - 1;
            y = y - 1;

            int [] bottomLeft = {x, y};

            if (inBounds(bottomLeft) == true)
            vector.add(bottomLeft);

        }

        //Bottom Right
        x = indexOne;
        y = indexTwo;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x - 1;
            y = y + 1;

            int [] bottomRight = {x, y};

            if (inBounds(bottomRight) == true)
            vector.add(bottomRight);

        }

        return vectorToArray(vector);
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
        // Scanner getCoordinate = new Scanner(System.in);
        // System.out.print("Attack Position: ");
        // String attackPosition = getCoordinate.nextLine();


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
            temp.availableCoordinates = generateBishopCoordinates(temp.position);
            
        }

    }

}