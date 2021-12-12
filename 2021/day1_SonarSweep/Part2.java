package day1_SonarSweep;

import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        Loader loader = new Loader("2021/day1_SonarSweep/input.txt");
        List<Integer> data = loader.getData();

        int j = 0;
        int currentSum = 0, previousSum = 0;
        int numberOfIncreasedSums = 0;
        for(int i = 0; i < data.size()-2; i++) {
            for( j = i ; j < i+3; j++) {
                currentSum += data.get(j);
            }

            if(currentSum > previousSum && i != 0) {
                numberOfIncreasedSums += 1;
            }
            previousSum = currentSum;
            currentSum = 0;
        }

        System.out.println(numberOfIncreasedSums);
    }
}
