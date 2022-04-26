package hwr.oop.exercises.gameoflife;

public class Cell {

    public Position position;

    private boolean isAlive;

    public Cell[] neighbours = new Cell[8];

    Cell(int x, int y){
        position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public Cell[] getNeighbours() {
        return new Cell[0];
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isDead() {
        return !isAlive;
    }

    public boolean isAliveNextGeneration() {
        //checkifdeadand3neighbours
        return false;
    }

    public void markAlive() {
        this.isAlive = true;
    }

    public void markDead() {
        this.isAlive = false;
    }
}
