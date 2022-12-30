package Lambda_Integer;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FrotanH_IntegerLambda {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 6, 9, 15, 8));

       // S1:listi aralarinda bosluk birakarak yazdiriniz //
        for (Integer w:list){
            System.out.println(w+" ");
        }
        //Lamnbda ile
        list.forEach(t-> System.out.print(t+" "));
        list.forEach(Utils::printInsameline);

        negatifolanlariYazdir(list);
        System.out.println(kareleriyazdir(list));
        kupbul(list);
        System.out.println(toplam(list));

    }

 public static void negatifolanlariYazdir( List<Integer> l){
     //S2: sadece negatif olanlari yazdir
     l.stream().filter(t->t<0).forEach(Utils::printInsameline);
 }

    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static List<Integer> kareleriyazdir(List<Integer> l){
     return   l.stream().map(t->t*t).collect(Collectors.toList());


    }
   //S6: listin elemanlarini kucukten buyuge siralayalim.
    public static void sirala(List<Integer> l){
        l.stream().sorted().forEach(Utils::printInsameline);
       l.stream().distinct().sorted().forEach(Utils::printInsameline);//tekrarsiz yazdir deseydi

        //buyukten kucuge yazdir
        l.stream().sorted(Comparator.reverseOrder()).forEach(Utils::printInsameline);

  }
// S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
     public static  List<Integer> kupbul(List<Integer> l){
      return   l.stream().distinct().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
  }
    // S10 :list elemanlarini toplamini bulalim
    public static  int toplam(List<Integer> l){
      return   l.stream().reduce(0,(a,b)->a+b);
     // return l.stream().reduce(Integer::sum);
    }

 }
