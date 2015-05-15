package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: dualpal
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class dualpal {

    public static String removeZero(String number) {
        String temp = number.replaceFirst("^0+(?!$)", "");
        return temp;
    }

    public static String baseConvertor(int number, int base) {
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

        return removeZero(result);
    }

    public static boolean isPalindromic(String number) {
        StringBuilder temp = new StringBuilder(number);
        String reversed = temp.reverse() + "";

        return number.equals(reversed);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("dualpal.in"));
        PrintWriter out = new PrintWriter(new File("dualpal.out"));

        int n = in.nextInt();
        int s = in.nextInt();

        int i = 0, base, temp = s + 1, cntr = 0;
        String converted;
        while (i != n) {
            for (base = 2; base <= 10; base++) {
                converted = baseConvertor(temp, base);
                if (isPalindromic(converted)) {
                    cntr++;
                    if (cntr >= 2) {
                        i++;
                        out.println(temp);
                        break;
                    }
                }
            }
            temp++;
            cntr = 0;
        }

        out.close();
        System.exit(0);
    }
}
