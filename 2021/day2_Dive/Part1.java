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

            switch(commandText) {
                case "forward":
                    x += value;
                    break;
                case "down":
                    y += value;
                    break;
                case "up":
                    y -= value;
                    break;
            }
        }

        System.out.println(x * y);
    }
}
