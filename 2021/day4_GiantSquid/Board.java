package day4_GiantSquid;

import java.util.List;

public class Board {
    private final List<List<BoardNumber>> board;

    public Board(List<List<BoardNumber>> board) {
        this.board = board;
    }

    public void setMarked(int number) {
        for(List<BoardNumber> l : board) {
            for(BoardNumber currentNumber : l) {
                if(currentNumber.getNumber() == number) {
                    currentNumber.mark();
                }
            }
        }
    }
}

class BoardNumber {
    private final int number;
    private boolean marked;

    public BoardNumber(int number) {
        this.number = number;
        this.marked = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean getMarked() {
        return marked;
    }

    public void mark() {
        this.marked = true;
    }
}
