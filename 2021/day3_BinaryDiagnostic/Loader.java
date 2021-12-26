package day3_BinaryDiagnostic;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Loader {
    private final List<List<Character>> lines;

    public Loader(String filePath) {
        lines = new ArrayList<>();
        loadData(filePath);
    }

    public List<List<Character>> getLines() {
        return lines;
    }

    private void loadData(String filePath) {
        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            while (scanner.hasNextLine()) {
                List<Character> line = scanner.nextLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

