package day3_BinaryDiagnostic;

public class BinaryConverter {

    public static int convertToDecimal(long binary) {
        int result = 0;
        String temp = Long.toString(binary);
        int[] bits = new int[temp.length()];
        for(int i = 0; i < temp.length() ; i++) {
            bits[i] = temp.charAt(i) - '0';
        }

        for(int i : bits) {
            result = result * 2 + i;
        }
        return result;
    }
}
