package day2_Dive;

// raw data structure
// there is no point in use of getters and setters in this case
public class Command {
    public String command;
    public Integer value;

    public Command(String command, int value) {
        this.command = command;
        this.value = value;
    }
}
