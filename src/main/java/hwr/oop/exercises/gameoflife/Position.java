package hwr.oop.exercises.gameoflife;

public class Position {

    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    boolean isNextTo(Position position){

            return false;
       /* for (int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if (this.x == position.x + i && this.y == position.y + j)
                    return true;
            }
        }
        return false;*/
    }

    boolean isEqualTo(Cell o){
        return this.x == o.getPosition().x && this.y == o.getPosition().y;
    }

}
