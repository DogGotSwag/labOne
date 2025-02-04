import java.util.Vector;

public class Rook {  
    public String color;
    public String position;
    public int[][] availableCoordinates;

    public String row = "abcdefgh";
    public String col = "87654321";

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
        int rookRow = col.indexOf(position.split("")[1]);
        int rookCol = row.indexOf(position.toLowerCase().split("")[0]);
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

    //constructor
    public Rook(String color, String position) { //change to class name
        this.color = color;
        this.position = position;
        this.availableCoordinates = generateCoordinates();
    }


    //main will be used test your available coordinates output
    public static void main(String[] args) {
        Rook test = new Rook ("white", "e4");  
        System.out.println(test.color);
        System.out.println(test.position);
        int[][] arr = test.availableCoordinates;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]+", "+arr[i][1]);
        }
    }
}