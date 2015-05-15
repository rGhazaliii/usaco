package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: transform
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class transform {

    public static String[] rotate(String[] initialMatrix) {
        String t = "";
        String temp[] = new String[initialMatrix.length];
        int i, j;
        for (j = 0; j < initialMatrix.length; j++) {
            for (i = initialMatrix.length - 1; i >= 0; i--) {
                t += initialMatrix[i].charAt(j);
            }
            temp[j] = t;
            t = "";
        }
        return temp;
    }

    public static String[] reflection(String[] matrix) {
        String t = "";
        String temp[] = new String[matrix.length];
        int i, j;
        for (i = 0; i < matrix.length; i++) {
            for (j = matrix[i].length() - 1; j >= 0; j--) {
                t += matrix[i].charAt(j);
            }
            temp[i] = t;
            t = "";
        }
        return temp;
    }

    public static boolean isEqual(String[] a, String[] b) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void isCombination(PrintWriter out) {
        out.println(5);
        out.close();
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        int n = in.nextInt();
        String[] initialMatrix = new String[n];
        String[] transfomedMatrix = new String[n];
        String[] temp;

        int i, j;
        for (i = 0; i < n; i++) {
            initialMatrix[i] = in.next();
        }
        for (i = 0; i < n; i++) {
            transfomedMatrix[i] = in.next();
        }

        temp = initialMatrix;
        for (i = 1; i < 8; i++) {
            temp = rotate(temp);

            if (isEqual(temp, transfomedMatrix)) {
                break;
            } else if (!isEqual(temp, transfomedMatrix) && i == 7) {
                break;
            } else if (isEqual(reflection(temp), transfomedMatrix) && i == 4) {
                break;
            } else if (isEqual(initialMatrix, transfomedMatrix) && i == 6) {
                break;
            } else if (i == 5) {
                temp = reflection(initialMatrix);
                for (j = 1; j < 4; j++) {
                    temp = rotate(temp);
                    if (isEqual(temp, transfomedMatrix)) {
                        isCombination(out);
                    }
                }
            }
        }

        out.println(i);
        out.close();
        System.exit(0);
    }
}
