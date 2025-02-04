public class Piece {
    public String color;
    public String position;
    public int[][] availableCoordinates;

    public Piece(String color, String position) {
        this.color = color.toLowerCase();
        this.position = position.toLowerCase();
    }
}