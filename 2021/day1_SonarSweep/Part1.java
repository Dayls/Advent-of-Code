package day1_SonarSweep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    private static List<Integer> result;

    public static void main(String[] args) {
        Loader loader = new Loader("2021/day1_SonarSweep/input.txt");
        List<Integer> data = loader.getData();
        result = new ArrayList<>();
        for(int i = 1; i < data.size(); i++) {
            Integer currentInt = data.get(i);
            Integer previousInt = data.get(i -1);

            if(currentInt > previousInt) {
                result.add(currentInt);
            }
        }

        System.out.println(result.size());
    }
}
