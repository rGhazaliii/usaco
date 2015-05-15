package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: beads
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class beads {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int n = in.nextInt();
        String s = in.next();

        int i, j, cntr = 0, max = 0;
        char temp;

        /* check if all characters of the string are equal */
        temp = s.charAt(0);
        boolean flag = true;
        for (i = 1; i < n; i++) {
            if (temp != s.charAt(i)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            out.println(s.length());
            out.close();
            System.exit(0);
        }
        /* end of check */

        for (i = 0; i < n; i++) {
            j = i;
            temp = s.charAt(i);

            if (temp != 'w') {
                while (s.charAt(j % n) == temp || s.charAt(j % n) == 'w') {
                    cntr++;
                    j = (j + 1) % n;
                    if (cntr == n) {
                        out.println(cntr);
                        out.close();
                        System.exit(0);
                    }
                }
                while (s.charAt(j) != temp || s.charAt(j) == 'w') {
                    cntr++;
                    j = (j + 1) % n;
                }
                if (cntr > max) {
                    max = cntr;
                    max += (s.charAt(Math.abs((i - 1) % n)) == 'w') ? 1 : 0;
                    max += (s.charAt((i + max - 1) % n) == 'w') ? 1 : 0;
                }
            }
            cntr = 0;
        }

        out.println(max);
        out.close();
        System.exit(0);
    }
}
