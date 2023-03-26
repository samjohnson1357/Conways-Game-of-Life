class PatternAcorn extends Pattern {

    // We declare our attributes.
    Cell cell1;
    Cell cell2;
    Cell cell3;
    Cell cell4;
    Cell cell5;
    Cell cell6;
    Cell cell7;
    public Cell[] cellArray;

    // This is the constructor.
    PatternAcorn() {

        // These are the cells that are considered to be alive.
        cell1 = new Cell(0, 2);
        cell2 = new Cell(1, 0);
        cell3 = new Cell(1, 2);
        cell4 = new Cell(3, 1);
        cell5 = new Cell(4, 2);
        cell6 = new Cell(5, 2);
        cell7 = new Cell(6, 2);

        // This is an array of living cells.
        cellArray = new Cell[] {cell1, cell2, cell3, cell4, cell5, cell6, cell7};
    }

    // This function returns the cell array.
    public Cell[] getCellArray() { return cellArray; }

    // This function returns the length of the x-axis.
    public int getSizeX() {
        return 7;
    }

    // This function returns the length of the y-axis.
    public int getSizeY() { return 3; }

    // This function returns true if the cell is alive and false otherwise.
    public boolean getCell(int x, int y) {

        // We already know which cells are true. We iterate through and locate each one.
        for (Cell cell : cellArray) {
            int cellX = cell.getX();
            int cellY = cell.getY();

            // Then, we compare each one to the values in the function header.
            if (x == cellX && y == cellY) {
                return true;
            }
        }
        // If we didn't locate the cell, we return false.
        return false;
    }
}