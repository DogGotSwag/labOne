import java.util.Vector;

public class Template {  //change class name
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
        // use vector.add() to add individual coordinate arrays into vector
        // see Knight.java to see it in action  
        //u can use inbounds method to check if a coordinate is valid

        /*
         * code here :]
         * happy coding
         */
        return vectorToArray(vector);
    }

    //constructor
    public Template(String color, String position) { //change to class name
        this.color = color.toLowerCase();
        this.position = position.toLowerCase();
        this.availableCoordinates = generateCoordinates();
    }


    //main will be used test your available coordinates output
    public static void main(String[] args) {
        Template test = new Template("red", "g8");  //change to class name
        System.out.println(test.color);
        System.out.println(test.position);
        int[][] arr = test.availableCoordinates;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]+", "+arr[i][1]);
        }
    }
}