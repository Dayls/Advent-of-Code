package day2_Dive;

import java.util.List;
import java.util.Map;

public class Part1 {
    public static void main(String[] args) {
        CommandLoader loader = new CommandLoader("2021/day2_Dive/input.txt");
        List<Command> commandList = loader.getData();

        int x = 0, y = 0;

        for(Command c : commandList) {
            String commandText = c.command;
            Integer value = c.value;

            switch (commandText) {
                case "forward" -> x += value;
                case "down" -> y += value;
                case "up" -> y -= value;
            }
        }

        System.out.println(x * y);
    }
}
