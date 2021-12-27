package day3_BinaryDiagnostic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Part2 {
    public static void main(String[] args) {
        String path = "2021/day3_BinaryDiagnostic/input.txt";
        int result = getDiagnostic(path);
        System.out.println(result);
    }

    public static int getDiagnostic(String filePath) {
        int oxygenRating = generateOxygenRating(filePath);
        int co2Rating = generateCO2Rating(filePath);
        return oxygenRating * co2Rating;
    }

    private static int generateOxygenRating(String filePath) {
        Loader dataLoader = new Loader(filePath);
        List<List<Character>> data = dataLoader.getLines();
        long oxygenRatingBinary = generateOxygenRatingBinary(data);
        return BinaryConverter.convertToDecimal(oxygenRatingBinary);
    }

    private static long generateOxygenRatingBinary(List<List<Character>> data) {
        int charIndex = 0;
        while(data.size() != 1) {
            data = getMostFrequent(data, charIndex);
            charIndex++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(char c : data.get(0)) {
            stringBuilder.append(c);
        }
        return Long.parseLong(stringBuilder.toString());
    }

    private static int generateCO2Rating(String filePath) {
        Loader dataLoader = new Loader(filePath);
        List<List<Character>> data = dataLoader.getLines();
        long co2RatingBinary = generateCO2RatingBinary(data);
        return BinaryConverter.convertToDecimal(co2RatingBinary);
    }

    private static long generateCO2RatingBinary(List<List<Character>> data) {
        int charIndex = 0;
        while(data.size() != 1) {
            data = getLeastFrequent(data, charIndex);
            charIndex++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(char c : data.get(0)) {
            stringBuilder.append(c);
        }
        return Long.parseLong(stringBuilder.toString());
    }

    private static List<List<Character>> getMostFrequent(List<List<Character>> lines, int charIdx) {
        return filter(lines, charIdx, (list0, list1) -> {
            if(list0.size() < list1.size() ||
            list0.size() == list1.size()) return list1;
            return list0;
        });
    }

    private static List<List<Character>> getLeastFrequent(List<List<Character>> lines, int charIdx) {
        return filter(lines, charIdx, (list0, list1) -> {
            if(list0.size() < list1.size() ||
            list0.size() == list1.size()) return  list0;
            return list1;
        });
    }

    private static List<List<Character>> filter(List<List<Character>> lines, int charIdx, BinaryOperator<List<List<Character>>> op) {
        List<List<Character>> result = copyList(lines);

        List<List<Character>> startWith0 = new ArrayList<>();
        List<List<Character>> startWith1 = new ArrayList<>();

        for (List<Character> currentLine : result) {
            if (currentLine.get(charIdx) == '1') {
                startWith1.add(currentLine);
            } else if (currentLine.get(charIdx) == '0') {
                startWith0.add(currentLine);
            }
        }

        return op.apply(startWith0, startWith1);
    }

    private static List<List<Character>> copyList(List<List<Character>> list) {
        List<List<Character>> result = new ArrayList<>();

        for (List<Character> characters : list) {
            List<Character> line = new ArrayList<>(characters);
            result.add(line);
        }

        return result;
    }
}
