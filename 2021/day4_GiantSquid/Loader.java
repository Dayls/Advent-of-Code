package day4_GiantSquid;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
            while(scanner.hasNextLine()) {
                if(scanner.nextLine().isEmpty()) {
                    this.boards.add(new Board(currentBoard));
                    currentBoard.clear();
                    continue;
                }
                List<BoardNumber> currentRow = new ArrayList<>();

                String[] rawRow = scanner.nextLine().split(" ");
                for(String s : rawRow) {
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
