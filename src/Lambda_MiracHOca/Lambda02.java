package Lambda_MiracHOca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi=new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));


     // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

        ciftKarePrint(sayi);
        System.out.println(" \n*********");
         tekKupYazdir(sayi); ////1332 -124 344 28 3376
        System.out.println(" \n*********");
        enBuyukEleman(sayi);
        System.out.println(" \n*********");
        elTopla(sayi);
}



    public static void ciftKarePrint( List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).// akistaki cift sayilari filtreledim dunku derste lamnd da bu methodu kullandigim icin oradan aldim
                map(t->t*t). // stream icerisindeki elemanlari baska tiplerie donusturur yani karesini aldik vs...
                forEach(Lambda01::yazdir);
}

//// Task 2: Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz
    public static void tekKupYazdir( List<Integer> sayi){
        sayi.
                stream().
                filter(t->(t&2) !=0).
                map(t->(t*t*t)+1).//1332 -124 344 28 3376
                forEach(Lambda01::yazdir);
    }

    //task 3:Task-3 : Functional Programming ile listin cift elemanlarinin
    //// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz.

    public static void cifKareKok(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->Math.sqrt(t)).//sqrt double veriyor bu nedenle lambda:.yazdir hata verdi
                forEach(t-> System.out.print(t+" "));//1.yol


    }

    //task 4:// Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void enBuyukEleman(List<Integer> sayi){
    Optional<Integer> maxSayi= sayi.
                stream().
                reduce(Math::max);// reduce methodu sadece  tek bir tane sayi buldugu icin yazdik.tek bir eleman bulmada reduce kullanilir
        System.out.println(maxSayi);   //reduce methodu terminel oldugu icin bundan sonra for each methodu calismaz
    }
    //structured yapi ile cozelim
    public static void structeredMaxBul(List<Integer> sayi){

       int max=Integer.MIN_VALUE;
      System.out.println("max ="+max);
      System.out.println("max = " + max); // max.soutv

       for(int i = 0; i<sayi.size(); i++) {
                if(sayi.get(i)>max) max = sayi.get(i);
              }
             System.out.println("en büyük sayı : " + max);


    }

    //task 5__>// Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxBul(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));//Math.max a gore daha hizli calisir

    }
     // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer> sayi){
     int top=   sayi.stream().reduce(0,(a,b)->a+b) ;
        System.out.println(top);

            /*
            * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
                bu örnekte 0 oluyor
            * b degerini her zamana  stream()'dan akısdan alır
            * a ilk degerinden sonraki her değeri action(işlem)'dan alır

            */                                                               


    }
         //task 7:        List deki cift elemanlarin carpimini yazdirin
    public static void carpimbul(List<Integer> sayi){
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> (a * b)));   //lambda expression
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));//method referance kullandik
    }


          //task 8:        list deki elemanlardan en kucugunu print ediniz

      public static void minBul(List<Integer> sayi){
        //1.yol
        System.out.println(sayi.
                stream().
                reduce(Integer::min));

             //2.yol
        System.out.println(sayi.stream().reduce(Lambda02::byMiracMin));
    }
    public  static int byMiracMin(int a,int b){
        return a<b ? a:b;
    }

    //task 9_> List teki 5 ten buyuk en kucuk tek sayiyi print ediniz
    public  static void sayiBul(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(a -> a > 5 && a % 2 != 0).
                reduce(Lambda02::byMiracMin));   //minumum  tek degeri bulmak icin


    }
    //task 10_  list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void siralamaYap(List<Integer> sayi){
         sayi.
                 stream().      //akisi baslattik
                 filter(Lambda01::ciftBul).   //akistaki cift sayilari bulduk
                 map(t->(t*t)) .                //sayilarin karesini aldik
                 sorted().                      // sayilari natural_order siraladik
                 forEach(Lambda01::yazdir);       //yazdirdik

    }
    }

