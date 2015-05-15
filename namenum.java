package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: namenum
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class namenum {

    public static String convertToNumber(String str) {
        String alphabet = "ABCDEFGHIJKLMNOPRSTUVWXYZ";
        String temp = "";

        for (int i = 0; i < str.length(); i++) {
            temp += ((int) (alphabet.indexOf(str.substring(i, i + 1)) / 3)) + 2;
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("namenum.in"));
        Scanner text = new Scanner(new File("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String n = in.next();

        boolean notFound = false;
        for (int i = 0; i < 4617; i++) {
            String str = text.nextLine();
            if (n.equals(convertToNumber(str))) {
                out.println(str);
                notFound = true;
            }

        }
        if (!notFound) {
            out.println("NONE");
        }
        out.close();
    }
}
