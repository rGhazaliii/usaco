package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: gift1
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class gift {

    public static int nameIndex(String[] names, String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        int n = in.nextInt();
        String persons[] = new String[n];
        int i;
        for (i = 0; i < n; i++) {
            persons[i] = in.next();
        }

        int personMoney[] = new int[n];
        int initialMoney[] = new int[n];
        for (i = 0; i < n; i++) {
            personMoney[i] = 0;
            initialMoney[i] = 0;
        }

        String giver;
        int toGive, j, giverMoney;
        String taker;
        for (i = 0; i < n; i++) {
            giver = in.next();
            giverMoney = in.nextInt();
            personMoney[nameIndex(persons, giver)] += giverMoney;
            initialMoney[nameIndex(persons, giver)] = giverMoney;
            toGive = in.nextInt();
            for (j = 0; j < toGive; j++) {
                taker = in.next();
                if (initialMoney[nameIndex(persons, giver)] != 0) {
                    personMoney[nameIndex(persons, taker)]
                            = personMoney[nameIndex(persons, taker)]
                            + initialMoney[nameIndex(persons, giver)] / toGive;
                }
            }
            if (initialMoney[nameIndex(persons, giver)] != 0) {
                personMoney[nameIndex(persons, giver)]
                        = personMoney[nameIndex(persons, giver)]
                        - initialMoney[nameIndex(persons, giver)]
                        + initialMoney[nameIndex(persons, giver)] % toGive;
            }

        }
        int finalValue;
        int index;
        for (i = 0; i < n; i++) {
            index = nameIndex(persons, persons[i]);
            finalValue = personMoney[index] - initialMoney[index];
            out.println(persons[index] + " " + finalValue);
        }

        out.close();
        System.exit(0);
    }
}
