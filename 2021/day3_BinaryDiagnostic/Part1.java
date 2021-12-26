package day3_BinaryDiagnostic;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
	private static final List<Character> gammaRate = new ArrayList<>();
	private static final List<Character> epsilonRate = new ArrayList<>();

	public static void main(String[] args) {
		long powerConsumption = getPowerConsumption("2021/day3_BinaryDiagnostic/input.txt");
		System.out.println(powerConsumption);

	}

	private static long getPowerConsumption(String filePath) {
		makeGammaAndEpsilonRate(filePath);
		long epsilonRateBinary = getEpsilonRateInBinary();
		long gammaRateBinary = getGammaRateInBinary();

		long epsilonRateDecimal = BinaryConverter.convertToDecimal(epsilonRateBinary);
		long gammaRateDecimal = BinaryConverter.convertToDecimal(gammaRateBinary);
		return epsilonRateDecimal * gammaRateDecimal;
	}

	private static void makeGammaAndEpsilonRate(String path) {
		List<List<Character>> data = getLines(path);
		calculateGammaAndEpsilonRate(data);
	}

	private static List<List<Character>> getLines(String path) {
		Loader loader = new Loader("2021/day3_BinaryDiagnostic/input.txt");
		return loader.getLines();
	}

	private static void calculateGammaAndEpsilonRate(List<List<Character>> data) {
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
	}

	private static long getGammaRateInBinary() {
		long gammaRateBinary = 0;
		StringBuilder builder = new StringBuilder();

		for (char c : gammaRate) {
			builder.append(c);
		}
		gammaRateBinary = Long.parseLong(builder.toString());
		return gammaRateBinary;
	}

	private static long getEpsilonRateInBinary() {
		long epsilonRateBinary = 0;
		StringBuilder builder = new StringBuilder();

		for(char c : epsilonRate) {
			builder.append(c);
		}
		epsilonRateBinary = Long.parseLong(builder.toString());
		return epsilonRateBinary;
	}
}
