package day3_BinaryDiagnostic;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
	public static void main(String[] args) {
		Loader loader = new Loader("2021/day3_BinaryDiagnostic/input.txt");
		List<List<Character>> data = loader.getLines();

		List<Character> gammaRate = new ArrayList<>();
		List<Character> epsilonRate = new ArrayList<>();

		int numberCount = 0;
		int index = 0;
		int current0 = 0, current1 = 0;
		for (int i = 0; i < data.size(); i++) {
			char current = data.get(i).get(index);
			if (current == '1') {
				current1++;
			} else if (current == '0') {
				current0++;
			}

			if (i == data.size() - 1) {
				if (current1 > current0) {

					gammaRate.add('1');
					epsilonRate.add('0');
				} else {
					gammaRate.add('0');
					epsilonRate.add('1');
				}

				index++;

				if (index > data.get(i).size() - 1) {
					break;
				}
				current0 = 0;
				current1 = 0;
				i = -1;
			}

		}
		System.out.println();
		for (char c : gammaRate) {
			System.out.print(c);
		}
		System.out.println();
		for (char c : epsilonRate) {
			System.out.print(c);
		}
	}
}

