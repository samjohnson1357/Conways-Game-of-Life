/*
The cell class is used to create simple cell objects with x and y coordinate values.
It makes things a little bit easier because you can access x and y values from one object.
The boolean alive value of the cell is held inside of a two-dimensional array instead of inside the object.
 */

import java.util.ArrayList;

public class Cell {

    // We declare the attributes.
    private final int x;
    private final int y;

    // This is the constructor.
    Cell (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // These are the accessor methods.
    public int getX() { return x; }
    public int getY() { return y; }

    // This function can be used to print up the x and y coordinates of a cell.
    static void printCellList(ArrayList<Cell> cellArrayList) {

        for (Cell cell : cellArrayList) {

            // We extract the relevant data.
            int x = cell.getX();
            int y = cell.getY();

            // Then, we print it in coordinate form.
            String coordinate = String.format("(%d, %d)", x, y);
            System.out.println(coordinate);
        }
    }
}