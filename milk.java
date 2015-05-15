package usaco;

/*
 ID: rghazal1
 LANG: JAVA
 TASK: milk
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class milk {

    private static class Farmer {

        public final int amount;
        public final int price;

        public Farmer(int price, int amount) {
            this.amount = amount;
            this.price = price;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("milk.in"));
        PrintWriter out = new PrintWriter(new File("milk.out"));

        int N = in.nextInt();
        int M = in.nextInt();

        List<Farmer> farmers = new ArrayList<Farmer>();
        for (int i = 0; i < M; i++) {
            farmers.add(new Farmer(in.nextInt(), in.nextInt()));
        }

        Collections.sort(farmers, new Comparator<Farmer>() {
            @Override
            public int compare(Farmer arg0, Farmer arg1) {
                return arg0.price - arg1.price;
            }
        });

        int amount = 0;
        int price = 0;
        for (Farmer farmer : farmers) {
            if (farmer.amount + amount >= N) {
                int diff = (N - amount);
                price += diff * farmer.price;
                amount += diff;
                break;
            } else {
                amount += farmer.amount;
                price += farmer.price * farmer.amount;
            }
        }

        out.println(price);

        out.close();
        System.exit(0);
    }

}
