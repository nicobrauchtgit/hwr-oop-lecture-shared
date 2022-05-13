package hwr.oop.exercises.gameoflife;

public class Field {

    private Cell[] cells;

    private int size;
    public Field(int size) {
        this.size = size;
        for (int i = 0; i < size * size; i++){
            cells[i] = new Cell(new Position(i % size, i / size));
        }
    }

    public Cell[] setNeighbours(){
       /* Cell[] neighbours
        for(Cell c : cells){
            Cell.neighbours =
        }*/
        return null;
    }

    public Cell getCellAt(Position position) {
        return cells[position.x + position.y * size];
    }
}
