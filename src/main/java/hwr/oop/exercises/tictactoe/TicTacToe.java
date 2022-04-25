package hwr.oop.exercises.tictactoe;

import java.util.Arrays;

class TicTacToe {
    int[][] squares;
    int[] crossWinArray = {1,1,1};
    int[] circleWinArray = {2,2,2};
    boolean gameOver;
    int turn;
    boolean turnPlayerA;
    boolean turnPlayerB;

    int lastX;
    int lastY;
    TicTacToe() {
        squares = new int[3][3];
        gameOver = false;
        turnPlayerA = true;
        turnPlayerB = true;
        turn = 0;
        lastX = 0;
        lastY = 0;
    }

    int getValueAt(int x, int y) {
            return squares[x][y];
    }

    void setCross(int x, int y) {
        if(turnPlayerA && squares[x][y] == 0 && !gameOver) {
            lastX = x;
            lastY = y;
            squares[x][y] = 1;
            turnPlayerA = false;
            turnPlayerB = true;
        }else{
            throw new RuntimeException("Not allowed!");
        }
    }

    void setCircle(int x, int y) {
        if(turnPlayerB && squares[x][y] == 0 && !gameOver) {
            lastX = x;
            lastY = y;
            squares[x][y] = 2;
            turnPlayerA = true;
            turnPlayerB = false;
        }else{
            throw new RuntimeException("Not allowed!");
        }
    }

    boolean isWin(int x, int y) {
        turn++;
        int[] winArray;
        if(!turnPlayerA)
            winArray = crossWinArray;
        else
            winArray = circleWinArray;

        if(Arrays.equals(squares[x], winArray))
            return true;

        int[] vertical = new int [squares[0].length];
        for(int i = 0; i < squares[0].length; i++)
            vertical[i] = squares[i][y];
        if(Arrays.equals(vertical, winArray))
            return true;

        if(x == y) {
            int[] diagonal = new int [squares[0].length];
            for (int i = 0; i < squares[0].length; i++)
                diagonal[i] = squares[i][i];
            if (Arrays.equals(diagonal, winArray))
                return true;
        }

        if ((x + y) == (squares[0].length - 1)){
            int[] antiDiagonal = new int [squares[0].length];
            for (int i = 0; i < squares[0].length; i++)
                antiDiagonal[i] = squares[i][(squares[0].length - 1)-i];
            if (Arrays.equals(antiDiagonal, winArray))
                return true;
        }
       return turn >= 9;
    }

    boolean isGameOver() {
        gameOver = isWin(lastX, lastY);
        if(gameOver)
            for(int[] numbers : squares)
                Arrays.fill(numbers, 0);
        return gameOver;
    }

}
