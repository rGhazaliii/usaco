package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: milk2
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class milk2 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        int n = in.nextInt();
        int[] begin = new int[n];
        int[] end = new int[n];
        int[] index = new int[n];

        int i;
        for (i = 0; i < n; i++) {
            begin[i] = in.nextInt();
            end[i] = in.nextInt();
            index[i] = i;
        }

        int j, temp;
        for (i = 0; i < (n - 1); i++) {
            for (j = 0; j < n - i - 1; j++) {
                if (begin[j] > begin[j + 1]) {
                    temp = begin[j];
                    begin[j] = begin[j + 1];
                    begin[j + 1] = temp;
                    temp = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = temp;
                }
            }
        }

        int low = begin[0];
        int high = end[index[0]];
        int maxInterval = high - low;
        int maxGap = 0;
        for (i = 0; i < n; i++) {
            if (begin[i] <= high) {
                high = Math.max(end[index[i]], high);
            } else {
                maxInterval = Math.max(maxInterval, high - low);
                maxGap = Math.max(maxGap, begin[i] - high);
                low = begin[i];
                high = end[index[i]];
            }
        }

        out.println(maxInterval + " " + maxGap);
        out.close();
        System.exit(0);
    }
}
