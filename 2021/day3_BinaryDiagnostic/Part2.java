package day3_BinaryDiagnostic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Part2 {
    public static void main(String[] args) {
        long oxygenRating, co2Rating;

        Loader dataLoader = new Loader("2021/day3_BinaryDiagnostic/input.txt");
        List<List<Character>> data = dataLoader.getLines();

        int charIndex = 0;
        while(data.size() != 1) {
            data = getOxygenRating(data, charIndex);
            charIndex++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(char c : data.get(0)) {
            stringBuilder.append(c);
        }
        oxygenRating = Long.parseLong(stringBuilder.toString());

        stringBuilder.setLength(0);
        data = dataLoader.getLines();
        charIndex = 0;
        while(data.size() != 1) {
            data = getCO2Rating(data, charIndex);
            charIndex++;
        }

        for(char c : data.get(0)) {
            stringBuilder.append(c);
        }
        co2Rating = Long.parseLong(stringBuilder.toString());

        int oxygenRatingDecimal, co2RatingDecimal;
        oxygenRatingDecimal = BinaryConverter.convertToDecimal(oxygenRating);
        co2RatingDecimal = BinaryConverter.convertToDecimal(co2Rating);

        System.out.println(oxygenRatingDecimal * co2RatingDecimal);
    }

    private static List<List<Character>> getOxygenRating(List<List<Character>> lines, int charIdx) {
        return filter(lines, charIdx, (list0, list1) -> {
            if(list0.size() < list1.size() ||
            list0.size() == list1.size()) return list1;
            return list0;
        });
    }

    private static List<List<Character>> getCO2Rating(List<List<Character>> lines, int charIdx) {
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
