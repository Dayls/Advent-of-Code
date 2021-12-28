package day4_GiantSquid;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<List<BoardNumber>> board;

    private int lastMarkedNumber;

    public Board(List<List<BoardNumber>> board) {
        this.board = board;
    }

    public void setMarked(int number) {
        for(List<BoardNumber> l : board) {
            for(BoardNumber currentNumber : l) {
                if(currentNumber.getNumber() == number) {
                    currentNumber.mark();
                    lastMarkedNumber = number;
                }
            }
        }
    }

    public boolean isWinning() {
        List<BoardNumber> currentCol = new ArrayList<>();
        List<BoardNumber> currentRow = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if(board.get(i).get(j).isMarked()) {
                    currentRow.add(board.get(i).get(j));
                }
                if(board.get(j).get(i).isMarked()) {
                    currentCol.add(board.get(j).get(i));
                }
            }
            if (currentRow.size() == board.size() || currentCol.size() == board.size()) {
                return true;
            }
            currentCol.clear();
            currentRow.clear();
        }

        return false;
    }

    public int getScore() {
        if (isWinning()) {
            return getUnmarkedNumbersSum() * getLastMarkedNumber();
        }

        return -1;
    }

    private int getUnmarkedNumbersSum() {
        int sum = 0;

        for(List<BoardNumber> l : board) {
            for(BoardNumber b : l) {
                if (!b.isMarked()) {
                    sum += b.getNumber();
                }
            }
        }

        return sum;
    }

    private int getLastMarkedNumber() {
        return lastMarkedNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<BoardNumber> l : board) {
            for (BoardNumber b : l) {
                builder.append(b.toString()).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
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

    public boolean isMarked() {
        return marked;
    }

    public void mark() {
        this.marked = true;
    }

    @Override
    public String toString() {
        return this.number + (marked ? "y" : "n");
    }
}
