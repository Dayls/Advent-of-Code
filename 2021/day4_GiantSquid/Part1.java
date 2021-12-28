package day4_GiantSquid;

import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        String path = "2021/day4_GiantSquid/input.txt";
        Loader loader = new Loader(path);
        List<Integer> numbers = loader.getNumbers();
        List<Board> boards = loader.getBoards();

        System.out.println(getTheFinalScore(numbers, boards));
    }

    private static void markAllBoards(List<Board> boards, int markedNumber) {
        for (Board b : boards) {
            b.setMarked(markedNumber);
        }
    }

    private static int getTheFinalScore(List<Integer> numbers, List<Board> boards) {
        for (Integer number : numbers) {
            markAllBoards(boards, number);
            for (Board b : boards) {
                if (b.isWinning()) {
                    return b.getScore();
                }
            }
        }
        return -1;
    }
}
