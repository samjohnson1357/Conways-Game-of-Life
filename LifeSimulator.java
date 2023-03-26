public class LifeSimulator {

    // We declare our instance variables.
    int sizeX;
    int sizeY;
    public boolean[][] patternArray;

    // This is the constructor.
    public LifeSimulator(int sizeX, int sizeY) {

        // We initialize our instance variables.
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        // We create a two-dimensional array.
        patternArray = new boolean[sizeX][sizeY];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public boolean getCell(int x, int y) {
        return patternArray[x][y];
    }

    // This function inserts a pattern into the pattern array.
    public void insertPattern(Pattern pattern, int startX, int startY) {

        // We iterate over the cells in the respective subclass.
        for (Cell currentCell : pattern.getCellArray()) {

            // We extract the x-value.
            int x = currentCell.getX();

            // We extract the y-value.
            int y = currentCell.getY();

            // We determine the new x-value.
            int newX = startX + x;

            // We determine the new y-value.
            int newY = startY + y;

            // We add a true value into that location.
            patternArray[newX][newY] = true;
        }
    }

    // This function is used to update the two-dimensional array of cells.
    public void update() {

        // We create a new grid of cells.
        boolean[][] newGrid = new boolean[sizeX][sizeY];

        // We iterate over the x values.
        for (int k = 1; k < sizeX - 1; k++) {

            // We iterate over the y values.
            for (int l = 1; l < sizeY - 1; l++) {

                // We get the number of neighbors that are alive.
                int liveN = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if (patternArray[k + i][l + j]) { liveN++; }
                // The current cell doesn't count toward the count of neighbor cells.
                if (patternArray[k][l]) { liveN--; }

                // A living cell dies of underpopulation.
                if ((patternArray[k][l]) && (liveN < 2)) { newGrid[k][l] = false; }

                // A living cell dies of overpopulation.
                else if ((patternArray[k][l]) && (liveN > 3)) { newGrid[k][l] = false; }

                // A new cell is born where no cell previously existed.
                else if ((!patternArray[k][l]) && (liveN == 3)) { newGrid[k][l] = true; }

                // Otherwise, no change occurs.
                else
                    newGrid[k][l] = patternArray[k][l];
            }
        }
        // We assign the pattern array object back to the new grid object.
        patternArray = newGrid;
    }
}