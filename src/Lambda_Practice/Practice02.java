package Lambda_Practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice02 {
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



        System.out.println(ilkHarfByk(list));
        System.out.println();
        System.out.println("ilkharf(list) = " + ilkharf(list));
        karakterEkle(list);
        System.out.println("icindeEolan(list) = " + icindeEolan(list));
        icindeLolan(list);

    }
    //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyel
    public static List<String> ilkHarfByk(List<String> l){

      return   l.
              stream().
              map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
              collect(Collectors.toList());

    }

     // S2: ilk harfi e ve ya c olanlari listeleyelim
     public static List<String> ilkharf(List<String> l){

      return  l.stream().filter(t->t.toLowerCase().startsWith("c") || t.toLowerCase().startsWith("e")).collect(Collectors.toList());

     }
      //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
      public static void karakterEkle(List<String> l){

        l.stream().map(t->"*"+ t +"*").forEach(Utils::yazString);


      }

      //S4 : icinde e olanlardan yeni bir list olusturunuz
      public static List<String> icindeEolan(List<String> l){
      return   l.
              stream().
              filter(t->t.toLowerCase().contains("e")).
              collect(Collectors.toList());
      }

       //S5: tum 'l' leri silelim yazdiralim
       public static void icindeLolan(List<String> l){

        l.stream().
                map(t->t.replaceAll("l","")).
                forEach(Utils::yazString);
       }
      //S6: List elemanarını 2.harfe gore sıralayıp
      //ilk 5 elemandan char sayısı en buyuk elemanı print

      public static void ikinciHarfeGoreSirala(List<String> l){

          System.out.println(l.stream().
                  sorted(Comparator.comparing(t -> t.charAt(1))). // list elemanlarini 2.harfe gore siraladim
                  limit(5). //ilk 5 elemani aldim
                  sorted(Comparator.comparing(String::length). //uzunlujklarina baktim
                  reversed()). //tersten siraladim
                  findFirst());  //akistan gelen ilk elemani aldim





      }

}
