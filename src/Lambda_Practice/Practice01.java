package Lambda_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice01 {

    public static void main(String[] args) {

        /*
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8))
      // S1:listi aralarinda bosluk birakarak yazdiriniz
         */
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        hepsiniYaz(list);
        System.out.println();
        negatifYaz(list);
        System.out.println();
        ciftYaz(list);
        System.out.println();
        posveciftYaz(list);
        System.out.println();
        posveyaciftYaz(list);
        System.out.println();
        elKareYaz(list);
        System.out.println();
        elKupYaz(list);
        System.out.println();
        System.out.println(pozKup5list(list));
        System.out.println();
        toplamBul(list);
        System.out.println();
        pozitifElemantop(list);

    }

    public static void hepsiniYaz(List<Integer> l) {
        l.stream().forEach(t -> System.out.println(t + " "));

    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifYaz(List<Integer> l) {
        l.stream().filter(t -> t < 0).forEach(t -> System.out.println(t + " "));


    }
    //S3: pozitif olanlardan yeni bir liste olustur

    public static void ciftYaz(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.println(t + " "));

    }

    //S4:pozitif ve çift olanları yazdırın
    public static void posveciftYaz(List<Integer> l) {

        l.stream().filter(t -> t % 2 == 0 && t > 0).forEach(t -> System.out.println(t + " "));
    }

    //S5:pozitif veya çift olanları yazdırın

    public static void posveyaciftYaz(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0 || t > 0).forEach(t -> System.out.println(t + " "));
    }

    // S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım
    public static void elKareYaz(List<Integer> l) {

        l.stream().map(t -> t * t).forEach(t -> System.out.println(t + " "));

        //map():stream den gelen elemanları baska ttıplere donusturmek veya uzerlerınde
//ıslem yapmak ıcın (update) kullanılır.

    }

    //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım
    public static void elKupYaz(List<Integer> l) {

        l.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).forEach(t -> System.out.println(t + " "));
    }

    //S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım

    public static void kareTekrarsiz(List<Integer> l) { //distinc methodu tekrarsiz yazdiryor
        l.stream().map(t -> t * t).distinct().forEach(t -> System.out.println(t + " "));

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
// Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
// Sıralı akışlar için, farklı elemanın seçimi sabittir
// (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
// Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.

    }
    //S9: listin elemanlarini kucukten buyuge siralayalim

    public static void elemanSirala(List<Integer> l) {
        l.stream().sorted().forEach(t -> System.out.println(t + " "));


    }
    //S10: listin elemanlarini buyukten kucuge siralayalim
    //sorted(Comparator.reverseOrder()) ==> Doğal sıralamanın tersini uygulayan bir karşılaştırıcı

    public static void terselemanSirala(List<Integer> l) {
        l.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.println(t + " "));
    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim

    public static List<Integer> pozKup5list(List<Integer> l) {
        return l.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());

    }

    public static void pozKup5list1(List<Integer> l) {
        List<Integer> list = l.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());
        System.out.println(list);
    }

//S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static List<Integer> pozkareson5(List<Integer> l) {
        List<Integer> list = l.stream().filter(t -> t > 0).map(t -> t * t).filter(t -> t % 10 != 0).collect(Collectors.toList());

        return list;
    }

    // S13 :list elemanlarini toplamini bulalim
    public static int toplamBul(List<Integer> l) {

        int i = l.stream().reduce(0, (x, y) -> x + y);

        return i;
    }

    public static int toplamBulreference(List<Integer> l) {

        int i = l.stream().reduce(0, Math::addExact);
        return i;

    }

    public static int toplamBulreferenceInt(List<Integer> l) {

        int i = l.stream().reduce(0,Integer::sum);
        return i;


    }

    //S14 : Listin pozitif elemanları toplamını bulalım
    public static void pozitifElemantop(List<Integer> l){
        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Integer::sum));
    }


/*
reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
kullanımı yaygındır pratiktir.
Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
  */

}



