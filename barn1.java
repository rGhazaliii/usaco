package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: barn1
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class barn1 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        int maxBoards = in.nextInt();
        int stallsNum = in.nextInt();
        int cowsNum = in.nextInt();

        int stall[] = new int[cowsNum];
        ArrayList<Gap> gaps = new ArrayList<Gap>();

        for (int i = 0; i < cowsNum; i++) {
            stall[i] = in.nextInt();
        }

        Arrays.sort(stall);

        for (int i = 1; i < cowsNum; i++) {
            if (stall[i] - stall[i - 1] > 1) {
                gaps.add(new Gap(stall[i - 1], stall[i]));
            }
        }

        Collections.sort(gaps);
        int boards = gaps.size() + 1;
        int coveredStalls = cowsNum; // first, all the cows need one board.
        Gap g;

        /* add the smallest gaps to the board width and leave the other gaps alone. */
        while (boards > maxBoards) {
            g = gaps.remove(0);
            coveredStalls += g.size();
            boards--;
        }

        out.println(coveredStalls);

        out.close();
        System.exit(0);
    }
}

/**
 *
 * @author reza
 *
 * Simple gap class that simulates spaces between two stalls.
 */
class Gap implements Comparable<Gap> {

    int start, end;

    Gap(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Gap o) {
        return size() - o.size();
    }

    public int size() {
        return end - start - 1;
    }

}
