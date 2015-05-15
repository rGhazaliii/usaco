package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: ride
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class ride {

    public static int letterValue(char c) {
        char letter[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < letter.length; i++) {
            if (letter[i] == c) {
                return i + 1;
            }
        }
        return -1;
    }

    public static boolean calculate(String s1, String s2) throws IOException {
        int i;
        double term1 = 1;

        for (i = 0; i < s1.length(); i++) {
            term1 *= (long) letterValue(s1.charAt(i));
        }

        double term2 = 1;
        for (i = 0; i < s2.length(); i++) {
            term2 *= (long) letterValue(s2.charAt(i));
        }

        return (term1 % 47 == term2 % 47);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String comet = in.nextLine();
        String ufo = in.nextLine();
        String result = calculate(comet, ufo) ? "GO" : "STAY";

        out.println(result);

        out.close();
        System.exit(0);
    }
}
