package day2_Dive;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommandLoader {
    private List<Command> commands;

    public CommandLoader(String path) {
        this.commands = new ArrayList<>();
        loadData(path);
    }

    public List<Command> getData() {
        return this.commands;
    }

    private void loadData(String path) {
        try(Scanner scanner = new Scanner(Paths.get(path))) {
            while(scanner.hasNext()) {
                String[] raw = scanner.nextLine().split(" ");
                String commandText = raw[0];
                int value = Integer.parseInt(raw[1]);

                Command command = new Command(commandText, value);
                this.commands.add(command);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
