public abstract class Pattern {

    // Below, we have our abstract methods.
    public abstract int getSizeX();
    public abstract int getSizeY();
    public abstract boolean getCell(int x, int y);

    // This is an additional important abstract method that we are including.
    public abstract Cell[] getCellArray();

}