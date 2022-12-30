package Lambda_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice03 {

    public static void main(String[] args) {

       PojoApartman daire1=new PojoApartman("dogu",3,4000);
       PojoApartman daire2=new PojoApartman("bati",2,2500);
       PojoApartman daire3=new PojoApartman("guney",1,3500);
       PojoApartman daire4=new PojoApartman("dogu",5,3000);

        List<PojoApartman> kiralikDaireler=new ArrayList<>(Arrays.asList(daire1,daire2,daire3,daire4));
        doguKiyasla(kiralikDaireler);
        System.out.println("katsayisi(kiralikDaireler) = " + katsayisi(kiralikDaireler));
        kiraFazlaBul(kiralikDaireler);
    }

    //dogu cephesindeki kiralık daireleri kiralarına göre sıralayın

    public static void doguKiyasla(List<PojoApartman> list){
        list.stream().filter(t->t.getCephe().equalsIgnoreCase("dogu")).//cephesi dogu olan daireleri filtreledim
        sorted(Comparator.comparing(PojoApartman::getKira)).forEach(System.out::println);
    }

      //kat sayısı 2den cok olan dairelerin kiralarını listeleyın
      public static List<Integer> katsayisi(List<PojoApartman> list){
      return   list.
              stream().
              filter(t->t.getKatSayisi()>2).// kat sayisi 2 den fazla olanlari aldim
              map(t->t.getKira()). //kira kismin aldim
              collect(Collectors.toList());// bunu listeledim
      }

      //kirası 3000den cok olan daireleri kat sayısı en az olanı yazdırın
      public static void kiraFazlaBul(List<PojoApartman> list){
        list.stream().filter(t->t.getKira()>3000).forEach(System.out::println);
      }



}
