package com.tsurkis.networkcallsautomation.screens.main;

import java.util.ArrayList;
import java.util.Arrays;

public class Test2 {
    static int subTotalCount = 0;       // gecerliToplamSayaci

    // Bu Method, Sayi Kumesi, Ulasilacak Hedef Sayi, ve Kullanilabilir Sayilari Parametre Olarak Alir
    public static void recursive_topla(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        // Toplam = 0;
        int sum = 0;
        // Kullanilabilir Sayilari Topla
        for (int i = 0; i < partial.size(); i++)
            sum += partial.get(i);
        // Eger Kullanilabilir Sayilar Hedef Sayiya Esitse
        if (sum == target)
            // Gecerli Toplam Sayacini 1 Arttir
            subTotalCount += 1;
        // Eger Toplam Hedef Sayiyi Gectiyse
        if (sum >= target)
            // Hic Bisey Yapma
            return;

        // Elimizdeki Sayilar Kadar Loop
        for (int i = 0; i < numbers.size(); i++) {
            // Eger Su An Bakilan Sayi, Hedef Sayiya Esit Degilse
            if (numbers.get(i) != target) {
                // Kullanilabilir Sayilari Toplamak Icin ArrayList Ac
                ArrayList<Integer> remaining = new ArrayList<Integer>();
                // Su An Bakilan Sayiyi n Olarak Kaydet
                int n = numbers.get(i);
                // Bakilan Sayidan Sonraki Her Sayi Icin Loop
                for (int j = i + 1; j < numbers.size(); j++)
                    // Kullanilabilir Sayilari ArrayList'e Ekle
                    remaining.add(numbers.get(j));

                // Kullanilabilir Sayilarin Bir Kopyasını Cikar
                ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
                // Bu Kumeye n Sayisini Ekle
                partial_rec.add(n);
                // Fonksiyonu Elimizdeki Butun Sayilar, Hedef Sayi ve
                // Guncel Kullanilabilir Sayilar Parametreleriyle Tekrar Cagir
                for (int sayi : partial_rec) {

                    System.out.println("Kullanılabilir Sayilar: " + sayi);
                }
                System.out.println("recursive_topla tekrar giriyor: ");
                recursive_topla(remaining, target, partial_rec);
            }
        }
    }

    // Bu Method Sayi Kumesini ve Ulasilacak Hedef Sayiyi Parametre Olarak Alir
    public static void topla(ArrayList<Integer> numbers, int target) {
        recursive_topla(numbers, target, new ArrayList<Integer>());
    }

    public static void main(String args[]) {
        // Sayi Kumesi
        Integer[] numbers = {3, 4, 9, 14, 15, 19, 28, 37, 47, 50, 54, 56, 59, 61, 70, 73, 78, 81, 92, 95, 97, 99};

        // Sayi Kumesi Boyutu Kadar Loop
        for (int i = 1; i < numbers.length; i++) {
            int target = numbers[i];    // Bulunmak Istenen Sayi kumenin i. Elemani
            topla(new ArrayList<Integer>(Arrays.asList(numbers)), target);
        }
        // GecerliSubToplamSayacini Ekrana Bas : 179
        System.out.println("Password : " + subTotalCount);
    }
}
