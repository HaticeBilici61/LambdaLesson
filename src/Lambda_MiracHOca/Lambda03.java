package Lambda_MiracHOca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu=new ArrayList<>(Arrays.asList("trilece","havucDilim","guvec","kokorec","kusleme","araBasi","waffle","kunefe"));

        alfBuyukHarf(menu);//ARABASİ GUVEC HAVUCDİLİM KOKOREC KUNEFE KUSLEME TRİLECE WAFFLE
        System.out.println();//10 7 6 5
        chrSayisiTerssiraUniq(menu);
        System.out.println();
        karakterEnBuyukEleman(menu);


    }

  //Task 1=List elemanlarini alfabetik buyuk harf ve tekrarsiz print edin.

    public static void alfBuyukHarf( List<String> yemek){
        yemek.
                stream(). //akis basladi
                map(String::toUpperCase). //buyuk harf kismi
                sorted().   //dogal siralama
                distinct(). //elamanlarin tekrarsiz olmasini
                forEach(t-> System.out.print(t+" "));  //yazdirdi


    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void chrSayisiTerssiraUniq(List<String> ikram){
        ikram.
                stream().//akisi
                map(String::length).//kelimelerin uzunlugu alindi
                sorted(Comparator.reverseOrder()).//tersten yazdirildi
                distinct().       //tekrarsiz yazdik
                forEach(Lambda01::yazdir);// yazdirdik
    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisikucuktenBuyuge(List<String> ikram){
        ikram.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(t-> System.out.println(t+" "));

    }
    public static void yazdir( int a){

    }

// ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.



    // Task-4 : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

   public static void harfSayisi7denAz(List<String> ikram){


       System.out.println( ikram.
               stream().
               allMatch(t->t.length()<=7) ? "List elemanlari 7 ve daha az harften olusuyor" : "list elemanlari 7 harften buyuk");

   }
// Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void elemanWileBaslayan(List<String> ikram){

        System.out.println( ikram.stream().noneMatch(t->t.startsWith("w")) ? "W ile yemek ismi mi olur" : " w ile yemek icat ettik");


        //2.yol yazma sekli
      //  boolean result =l.noneMatch(t -> t.startsWith("w"));


}

  // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

  public static void elemanXileBiten(List<String> ikram){
      System.out.println( ikram.stream().anyMatch(t->t.endsWith("x"))  ? " masallah" : " x le yemek biter mi hic ");

  }
     // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void karakterEnBuyukEleman(List<String> ikram){
    Stream<String> maxEleman  =  ikram.
                stream().//akis
                sorted(Comparator.comparing(t->t.toString().
                length()).reversed()). //karakter sayisina gore tersten siraladik
                limit(1); //ilk eleman cagirdik

        System.out.println(Arrays.toString( maxEleman.toArray()));

        //maxEleman.toArray())--->Stream olan akis Array e cevrildi
        //Arrays.toString( maxEleman.toArray())--> Array i String yapiya cevirdik
    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilkElHaricSonHrfSiralam(List<String> ikram){

        ikram.
                stream(). //akis saglandi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). //son harfine gore alfabetik siraladi
                skip(1).  // akistaki ilk elaman haric tutuldu
                forEach(Lambda01::yazdir); //yazdirildi

    }




    }


