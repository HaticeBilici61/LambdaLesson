package Lambdacalismalari;

import Lambda_MiracHOca.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda_sorularteam {
    public static void main(String[] args) {

        List<String> list=new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");


//S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim

        System.out.println(list.stream().
                map(t -> t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase()).
                collect(Collectors.toList()));


// S2: ilk harfi e ve ya c olanlari listeleyelim

        System.out.println(list.stream().
                filter(t -> t.toLowerCase().substring(0, 1).contains("e") || t.toLowerCase().substring(0, 1).contains("c")).
                collect(Collectors.toList()));


        //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim

        list.stream().map(t->"*"+ t +"*").forEach(t-> System.out.println(t+" "));

        System.out.println("************************");

        //S7: uzunlugu 3 ile 7 arası olan veya a ile biten elemanlardan yeni bir liste olustur.

        System.out.println(list
                .stream().
                filter(t -> t.length() > 3 && t.length() < 7 || t.toLowerCase().endsWith("a")).
                collect(Collectors.toList()));

        System.out.println("***********");

      //S8: list elemanlarını uzunluklarına ve ikinci harflerine göre benzersiz sıralayıp yazdırın(bakilacak)
        System.out.println(list.stream().sorted(Comparator.comparing(String::length).thenComparing(t -> t.charAt(1))).distinct().collect(Collectors.toList()));


        System.out.println("******************");
        // S9: uzunlugu 4 ve 8 olanlar haric bir liste olusturunuz

        System.out.println(list
                .stream().
                filter(t -> t.length() != 4 && t.length() != 8).
                collect(Collectors.toList()));

        System.out.println("***********************");

        //S10: List elemanlarını son harfe göre sıralayıp, son 3 elemanı yazdırın.

        System.out.println(list.stream().
              //  sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()).
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).skip(list.size() - 3).//son 3 elaman
                limit(3).
                collect(Collectors.toList()));

        System.out.println("***************");

        //S4 : icinde e olanlardan yeni bir list olusturunuz
        System.out.println(list.stream().filter(t -> t.contains("e")).collect(Collectors.toList()));


        System.out.println("***********************");

        //S6: List elemanarını 2.harfe gore sıralayıp
       //ilk 5 elemandan char sayısı en buyuk elemanı print

      list.stream().
             sorted(Comparator.comparing(t->t.charAt(1))).limit(5).
             sorted(Comparator.comparing(String::length)).skip(4).
             forEach(Lambda01::yazdir);

        // İki Dize Dizisi arasındaki ortak öğeleri bulan bir program yazın (büyük/küçük harf duyarlılığı olmadan)
        // girdi 1= {John,Brad,Ange,Sofya,Emily}
        // Girdi2 : {sofya, brad, zarafet, emily, ela}


        List<String> arr=new ArrayList<>(Arrays.asList("JOHN","brad","ange","sofya","emily"));
        List<String> brr=new ArrayList<>(Arrays.asList("zerafet","brad","ela","Sofya","emily"));
        List<String> bos=new ArrayList<>();

        for (int i = 0; i < brr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(i).equalsIgnoreCase(brr.get(j))) {
                    bos.add(arr.get(i));
                }
            }
        }
        System.out.println(bos);



        // Bir diziden belirli bir öğeyi kaldıran ve kalan öğeleri yeni bir diziye koyan ve yeni diziyi yazdıran bir Java programı yazın

        List<Integer> list1 = new ArrayList<>(Arrays.asList(167, 245, 37, 421, 52, 6890));
        list1.remove((Integer) 52);
        System.out.println(list);
        list1.add(1);
        System.out.println(list1);

        System.out.println(list1.stream().filter(t ->t != 52).collect(Collectors.toList()));



    }
}
