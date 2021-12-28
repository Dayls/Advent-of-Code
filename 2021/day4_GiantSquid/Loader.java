package day4_GiantSquid;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Loader {
    private final List<Integer> numbers;
    private final List<Board> boards;

    public Loader(String filePath) {
        numbers = new ArrayList<>();
        boards = new ArrayList<>();

        loadData(filePath);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Board> getBoards() {
        /*
        for (Board b : boards) {
            System.out.println(b);
        }*/
        return boards;
    }

    private void loadData(String filePath) {
        loadNumbers(filePath);
        loadBoards(filePath);
    }

    private void loadNumbers(String filePath) {
        try(Scanner scanner = new Scanner(Paths.get(filePath))) {
            String[] rawNumbers = scanner.nextLine().split(",");
            for(String letter : rawNumbers) {
                numbers.add(Integer.parseInt(letter));
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void loadBoards(String filePath) {
        try(Scanner scanner = new Scanner(Paths.get(filePath))) {
            List<List<BoardNumber>> currentBoard = new ArrayList<>();
            scanner.nextLine();
            while(true) {
                String nextLine;
                try {
                    nextLine = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    this.boards.add(new Board(new ArrayList<>(currentBoard)));
                    break;
                }

                if(nextLine.isBlank()) {
                    if (currentBoard.isEmpty()) {
                        continue;
                    }
                    this.boards.add(new Board(new ArrayList<>(currentBoard)));
                    currentBoard.clear();
                    continue;
                }
                List<BoardNumber> currentRow = new ArrayList<>();

                String[] rawRow = nextLine.split(" ");
                for(String s : rawRow) {
                    if (s.isBlank()) {
                        continue;
                    }
                    int number = Integer.parseInt(s);
                    BoardNumber boardNumber = new BoardNumber(number);
                    currentRow.add(boardNumber);
                }
                currentBoard.add(currentRow);
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
