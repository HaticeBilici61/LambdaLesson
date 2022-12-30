package Lambdacalismalari;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda_soru_Team {

    public static void main(String[] args) {
        //  10 öğelik bir liste oluşturun. 8. öğeyi 3. öğeyle değiştirin.
        String[] name = {"Ümit", "Emin", "Kemal", "Kerem", "Taylan", "Orhan", "Sinan", "Furkan", "Ahmet", "Ali"};








       Stream<String> st=Stream.of(name);
      //  System.out.println(st.map().collect(Collectors.toList()));


    }
    //  Bir tamsayıyı girdi olarak kabul eden ve girdiden büyük olan ilk 10 asal sayıyı ekrana yazdıran bir program yazınız.
    public static void asalBul(int girdi) {

        IntStream.iterate(girdi, t -> t + 1).filter(Lambda_soru_Team::asal).limit(10).forEach(t -> System.out.print(t + " "));

    }

    public static boolean asal(int a) {
        int counter = 0;
        boolean sonuc = true;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                counter++;
                sonuc = false;
                break;
            }
        }
        if (counter == 0) {
            sonuc = true;
        }
        return sonuc;

    }

}