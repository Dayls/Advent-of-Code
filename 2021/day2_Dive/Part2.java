package day2_Dive;

import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        int x = 0, y = 0, aim = 0;
        List<Command> commandList = new CommandLoader("2021/day2_Dive/input.txt").getData();

        for(Command c : commandList) {
            String commandText = c.command;
            Integer value = c.value;

            switch (commandText) {
                case "down":
                    aim += value;
                    break;
                case "up":
                    aim -= value;
                    break;
                case "forward": {
                    x += value;
                    y += (aim * value);
                    break;
                }
            }
        }
        System.out.println(x * y);
    }
}
