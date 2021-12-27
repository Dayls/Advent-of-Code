package day4_GiantSquid;

import java.util.ArrayList;
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

    public boolean isWinning() {
        List<BoardNumber> currentCol = new ArrayList<>();
        List<BoardNumber> currentRow = new ArrayList<>();

        for(int i = 0 ; i < board.size(); i++) {
            for(int j = 0; j < board.get(i).size(); j++) {
                if (j == board.get(i).size()-1) {
                    currentRow.clear();
                }
                if(i == board.get(j).size()-1) {
                    currentCol.clear();
                }
                currentRow.add(board.get(i).get(j));
                currentCol.add(board.get(j).get(i));
            }
            if(currentRow.size() == board.size() || currentCol.size() == board.size()) {
                return true;
            }
        }

        return false;
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
