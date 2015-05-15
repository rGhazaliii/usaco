package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: palsquare
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class palsquare {

    public static int baseConvertor(int number, int base) {
        int reminder, quotient;
        String result = "";

        do {
            quotient = number / base;
            reminder = number % base;
            number = quotient;
            result += String.valueOf(reminder);

        } while (quotient >= base);
        result += quotient;

        StringBuilder temp = new StringBuilder(result);
        result = temp.reverse() + "";

        return Integer.parseInt(result);
    }

    public static boolean isPalindromic(int number) {
        String stringNumber = String.valueOf(number);
        StringBuilder temp = new StringBuilder(stringNumber);
        String reversed = temp.reverse() + "";

        return stringNumber.equals(reversed);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("palsquare.in"));
        PrintWriter out = new PrintWriter(new File("palsquare.out"));

        System.out.println(baseConvertor(10, 15));
        int B = in.nextInt();
        int i, convertedNumber, squared, squaredInBase;
        try {
            for (i = 1; i <= 300; i++) {
                convertedNumber = baseConvertor(i, B);
                convertedNumber = Integer.parseInt(Integer.toString(i, B));
                squared = (int) Math.pow(i, 2);
                squaredInBase = baseConvertor(squared, B);

                if (isPalindromic(squaredInBase)) {
                    out.println(convertedNumber + " " + squaredInBase);
                }
            }
        } catch (NumberFormatException e) {

        }

        out.close();
        System.exit(0);
    }
}
