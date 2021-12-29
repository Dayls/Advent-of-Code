package day4_GiantSquid;

import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        Loader loader = new Loader("2021/day4_GiantSquid/input.txt");
        List<Board> boards = loader.getBoards();
        List<Integer> numbers = loader.getNumbers();

        System.out.println("The last score is " + getTheLastScore(boards,numbers));
    }

    private static int getTheLastScore(List<Board> boards, List<Integer> numbers) {
        outer:
        for (Integer n : numbers) {
            markAllBoards(boards, n);
            for(int i = 0; i < boards.size(); i++) {
                if (boards.get(i).isWinning()) {
                    if (boards.size() == 1) { break outer; }
                    boards.remove(boards.get(i));
                }
            }
        }
        return boards.get(0).getScore();
    }

    private static void markAllBoards(List<Board> boards, int number) {
        for(Board b : boards) {
            b.setMarked(number);
        }
    }
}
