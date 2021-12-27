package day4_GiantSquid;

import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        String path = "2021/day4_GiantSquid/input.txt";
        Loader loader = new Loader(path);
        List<Integer> numbers = loader.getNumbers();
        List<Board> boards = loader.getBoards();


    }
}
