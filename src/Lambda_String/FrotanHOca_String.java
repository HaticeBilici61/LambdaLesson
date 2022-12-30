package Lambda_String;

import Lambda_Integer.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FrotanHOca_String {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");


        IlkHarf(list);
        System.out.println();
       yildizKoy(list);
        System.out.println();
        eOlan(list);
        ilkHarfucjereyazdir(list);

    for (String w :list){
        System.out.print(w+" ");
 }
    //Lambda ile functional
        list.forEach(Utils::printInsameline);

    }
    public static void IlkHarf( List<String> l){
        /// S1: ilk harfi d ve ya c olanlari listeleyelim
        System.out.println();
        l.stream().filter(t->t.startsWith("d")||t.startsWith("c")).collect(Collectors.toList());

    }

    public static void yildizKoy( List<String> l){

        ///S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
        System.out.println();
        l.stream().map(t->"*"+t+"*").forEach(Utils::printInsameline);
    }

    public static void siralama( List<String> l){

        //S3: alfabetik  olarak siralayalim list olarak
        System.out.println();
        l.stream().sorted().collect(Collectors.toList()).forEach(Utils::printInsameline);

    }
    public static void terstenyazdir( List<String> l){
        l.stream().sorted(Comparator.reverseOrder()).forEach(Utils::printInsameline);


    }
    public static void Lsil( List<String> l){

        //S4: tum ‘l’ leri silelim yazdiralim
        System.out.println();
        l.stream().map(t->t.replace("l","")).forEach(Utils::printInsameline);
    }

    public static List<String> eOlan( List<String> l){

        //S5 : icinde e olanlardan yeni bir list olusturunuz
      return   l.stream().filter(t->t.contains("e")).collect(Collectors.toList());


    }
    public static void ilkHarfucjereyazdir( List<String> l){

        // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi
        System.out.println();
        l.stream().map(t->t.substring(0,1)+t.substring(0,1)+t.substring(0,1)+t).forEach(Utils::printInsameline);
        l.stream().map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).forEach(Utils::printInsameline);
    }
    public static void uzunlukyazdir( List<String> l){
        // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz
        l.stream().filter(t-> t.length()==4 || t.length()==6).collect(Collectors.toList());


    }
    //
}
