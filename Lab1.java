import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;

public class Lab1 {

    public static String[] txt2arr() throws Exception {

        File Pieces = new File ("./input.txt");

        Scanner scnr = new Scanner(Pieces);

        String input [] = new String[6];

        int x = 0;

        while (scnr.hasNextLine()) {
            String txtline = scnr.nextLine();
            input[x] = txtline;
            x++;
            
        }

        return input;

    }

    public static void main (String [] args) throws Exception {

        Scanner userInput = new Scanner(System.in);
        String [] pieces = txt2arr();

        String columns = "abcdefgh";
        String rows = "87654321";

        char letter = '\0';
        int number = -1;

        while (true) {
            System.out.println("Please enter the move you would like to check: (e.g., E6)");
            String userMove = userInput.nextLine();

            if (userMove.length() == 2) {
                char first = userMove.charAt(0);
                char second = userMove.charAt(1);

                if (Character.isDigit(second) && Character.isLetter(first)) {
                    number = Character.getNumericValue(second);
                    letter = first;
                    letter = Character.toLowerCase(first);

                    if ((letter >= 'a' && letter <= 'h') || (letter >= 'A' && letter <= 'H')) {
                        break;

                    }

                    else {
                        System.out.println("Invalid! Letter coordinate should be from A-H or a-h \n");

                    }

                }

                else {
                    System.out.println("Invalid! The move should include the letter first \n");

                }

            }

            else {
                System.out.println("Invalid! The move should only be two digits long \n");

            }

        }
        
        for (int i = 0; i < pieces.length; i++) {
            String [] attributes = pieces[i].split(", ");
            String name = attributes[0];
            String color = attributes[1];
            char column = attributes[2].charAt(0);
            int row = Integer.parseInt(attributes[3]);
            String startposition = "" + column + row;
            String nextmove = "" + number + letter;
            boolean possible = false;
            int[][] availableCoordinates;

            availableCoordinates = generateCoordinates(startposition, name, color);

            int indexOne = rows.indexOf(nextmove.split("")[0]);
            int indexTwo = columns.indexOf(nextmove.split("")[1]);

            int [] move = {indexOne, indexTwo};

            for (int j = 0; j < availableCoordinates.length; j++) {
                if (Arrays.equals(move, availableCoordinates[j])) {
                    possible = true;
                    break;

                }

            }
                
            if (possible) {
                System.out.println(name + " at " + column + ", " + row + " can move to " + letter + ", " + number);

            }
                
            else {
                System.out.println(name + " at " + column + ", " + row + " can't move to " + letter + ", " + number);

            }

        }

    }

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

    public static int[][] generateCoordinates(String position, String name, String color) {
        Vector<int[]> vector = new Vector<>();
        String letters = "abcdefgh";
        String numbers = "87654321";

        if (name.equals("King")) {

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
            
        }

        else if (name.equals("Rook")) {

            int rookRow = numbers.indexOf(position.split("")[1]);
            int rookCol = letters.indexOf(position.toLowerCase().split("")[0]);

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

        }

        else if (name.equals("Pawn")) {
            int rows = numbers.indexOf(position.charAt(1));
            int cols = letters.indexOf(position.charAt(0));

            int direction = (color.equals("white")) ? -1 : 1;

            // Forward move
            int[] forwardMove = { rows + direction, cols };
            if (inBounds(forwardMove)) {
                vector.add(forwardMove);
            }

        }

        else if (name.equals("Knight")) {
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

        }

        else if (name.equals("Queen")) {
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

        }

        else if (name.equals("Bishop")) {

            int indexOne = numbers.indexOf(position.split("")[1]);
            int indexTwo = letters.indexOf(position.split("")[0]);
        
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

        }

        return vectorToArray(vector);

    }
        
}