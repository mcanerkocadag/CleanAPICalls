package com.tsurkis.networkcallsautomation.screens.main;

public class Test {

    public static void main(String args[]) {

        int ind = 0;
        int x = -1;
        boolean sayiBulundumu = false;
        while (!sayiBulundumu) {

            x = fibonacciSayisiBul(ind++);
            if (x > 227000 && asalMi(x)) {
                sayiBulundumu = true;
                System.out.print("Sayi: " + x);
            }
        }

        int y = ++x;
        int toplam = asalBölenlerininToplaamınıBul(y);

        System.out.print("\nToplam Sayi " + toplam);
    }

    private static int asalBölenlerininToplaamınıBul(int y) {

        print("asalBölenlerininToplaamınıBul Sayi:" + y);
        int toplam = 0;
        for (int i = 2; i < y; i++) {

            if (y % i != 0)
                continue;

            if (!asalMi(i))
                continue;

            print("asalBölenlerininToplaamınıBul x:" + i);
            toplam += i;
        }

        return toplam;

    }

    private static void print(String s) {
        System.out.println("" + s);
    }

    private static int fibonacciSayisiBul(int n) {
        if (n < 2)
            return n;

        return fibonacciSayisiBul(n - 2) + fibonacciSayisiBul(n - 1);
    }

    private static boolean asalMi(int x) {

        for (int i = 2; i < x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

}
