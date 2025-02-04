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

    public static int[][] generatePawnCoordinates(String position, String color) {
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

    public static int[][] generateRookCoordinates(String position) {
        Vector<int[]> vector = new Vector<>();
        int rookRow = rows.indexOf(position.split("")[1]);
        int rookCol = columns.indexOf(position.split("")[0]);
        //uses a for loop to generate horizontal moves
          for(int i=0; i<8; i++){
              if(i!=rookCol){
                  int[]coordinate={rookRow,i};
                  if(inBounds(coordinate)){
                      vector.add(coordinate);
                  }
              }
          }  
        //same loop but for vertical moves
        for(int i=0; i<8; i++){
              if(i!=rookRow){
                  int[]coordinate={i,rookCol};
                  if(inBounds(coordinate)){
                      vector.add(coordinate);
                  }
              }
          }  
       
        return vectorToArray(vector);
       
    }

    public static int[][] generateKnightCoordinates(String position) {
        Vector<int[]> vector = new Vector<>();
        String letters = "abcdefgh";
        String numbers = "87654321";

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

    public static int[][] generateQueenCoordinates(String position) {
        Vector<int[]> vector = new Vector<>();

        String letters = "abcdefgh";
        String numbers = "87654321";

        int rows = numbers.indexOf(position.split("")[1]);
        int cols = letters.indexOf(position.split("")[0]);

        //up down left right
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

        //diagonal movement
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


        for (int i = 0; i < 1; i++) {
            // String[] info = vector.get(i).split(", ");
            // String type = info[0];
            // String color = info[1];
            // String position = info[2]+""+info[3];
            // System.out.println(type);
            // System.out.println(color);
            // System.out.println(position);
            // System.out.println("--------");

            Piece temp = new Piece("white", "g1" );
            temp.availableCoordinates = generateKnightCoordinates(temp.position);

            for(int j = 0; j < temp.availableCoordinates.length; j+=1){
                System.out.print(temp.availableCoordinates[j][0]+",");
                System.out.print(temp.availableCoordinates[j][1]);
                System.out.println("");
            }
            
        }

    }

}