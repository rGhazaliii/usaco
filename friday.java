package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: friday
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class friday {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new File("friday.out"));
        int years = in.nextInt();

        int repeat[] = new int[7];
        Arrays.fill(repeat, 0);

        int calendarDay = 0;
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapDays = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int n = 1900 + years;
        for (int year = 1900; year < n; year++) {
            for (int month = 0; month < 12; month++) {
                int day = (calendarDay + 12) % 7;
                repeat[day]++;
                calendarDay += leapYear(year) ? leapDays[month] : days[month];
            }
        }

        out.print(repeat[5]);
        out.print(' ');
        out.print(repeat[6]);
        out.print(' ');
        out.print(repeat[0]);
        out.print(' ');
        out.print(repeat[1]);
        out.print(' ');
        out.print(repeat[2]);
        out.print(' ');
        out.print(repeat[3]);
        out.print(' ');
        out.println(repeat[4]);

        out.close();
    }

    public static boolean leapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }
}
