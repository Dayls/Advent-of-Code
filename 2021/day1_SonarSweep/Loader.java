package day1_SonarSweep;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {

    private List<Integer> data;

    public Loader(String path) {
        this.data = new ArrayList<>();

        loadData(path);
    }

    public List<Integer> getData() {
        return this.data;
    }

    private void loadData(String path) {
        try (Scanner scanner = new Scanner(Paths.get(path))) {
            while(scanner.hasNext()) {
                Integer i = Integer.valueOf(scanner.nextLine());
                this.data.add(i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

