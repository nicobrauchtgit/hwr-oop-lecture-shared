package hwr.oop.exercises.gameoflife;

public class Field {

    private Cell[][] cells;
    public Field(int size) {
        cells = new Cell[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                cells[i][j] = new Cell(i ,j);

            }
        }
    }

    public Cell[] setNeighbours(){
        Cell[] neighbours
        for(Cell c : cells){
            Cell.neighbours =
        }
    }
    public Cell getCellAt(Position position) {
        return cells[position.x][position.y];
    }
}
