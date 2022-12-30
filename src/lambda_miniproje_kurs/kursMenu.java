package lambda_miniproje_kurs;

import Lambda_MiracHOca.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class kursMenu {

          /*Can sınıfını kullanarak 4 nesne oluştur(
            özel String sezonu;
            private String kursuAdı;
             özel int ortalamaPuan;
             private int numOfStudent;
            ) */

    public static void main(String[] args) {
        CanPojo ogr1 = new CanPojo("Kis", "Java", 64, 100);
        CanPojo ogr2 = new CanPojo("Kis", "Sql", 76, 101);
        CanPojo ogr3 = new CanPojo("Yaz", "Deutsch", 87, 102);
        CanPojo ogr4 = new CanPojo("Sonbahar", "Math", 96, 154);

        //Onları bir listeye ekle
        List<CanPojo> list=new ArrayList<>(Arrays.asList(ogr1,ogr2,ogr3,ogr4));
        System.out.println(norOrtKontrol(list));
        System.out.println(gunICeriyormu(list));
        System.out.println(ogrencisayisVarmi(list));
        System.out.println(kisMI(list));
        System.out.println(ogrNovarMi(list));
        System.out.println(siralama(list));
        terstenYazdir(list);
        kursAditerstenYazdir(list);
    }
    //Tüm ortalama puanların 98'den az olup olmadığını kontrol edin

    public static boolean norOrtKontrol( List<CanPojo> list){
      return  list.stream().allMatch(t->t.getOrtPuan()<98);
    }


    //Tüm ders adlarının "Gün" kelimesini içerip içermediğini kontrol edin
    public static boolean gunICeriyormu( List<CanPojo> list){
     return   list.stream().allMatch(t->t.getKursAdi().contains("Gun"));
    }


    //Herhangi bir öğrenci sayısının 154 olup olmadığını kontrol edin
    public static boolean ogrencisayisVarmi( List<CanPojo> list){
       return list.stream().anyMatch(t->t.getOgrNo()==154);
    }

    // Herhangi bir mevsimin Kış olup olmadığını kontrol edin
    public static boolean kisMI( List<CanPojo> list){
      return  list.stream().anyMatch(t->t.getSezon().equalsIgnoreCase("Kis"));
    }

    //Herhangi bir öğrenci sayısının 100 olup olmadığını kontrol edin

    public static boolean ogrNovarMi( List<CanPojo> list){
       return  list.stream().anyMatch(t->t.getOgrNo()==100);
    }

    //Öğeleri ortalama puana göre doğal sırayla sırala
    public static List<CanPojo>   siralama( List<CanPojo> list){
      return  list.stream().sorted(Comparator.comparing(CanPojo::getOrtPuan)).collect(Collectors.toList());
    }

    //Öğeleri öğrenci sayısına göre ters sırada sırala
    public static void terstenYazdir( List<CanPojo> list){
        list.stream().sorted(Comparator.comparing(CanPojo::getOgrNo).reversed()).forEach(t-> System.out.println(t+" "));
    }

    //Kurs adına göre öğeleri ters sırada sıralayın
    public static void kursAditerstenYazdir( List<CanPojo> list){
        list.stream().sorted(Comparator.comparing(CanPojo::getKursAdi).reversed()).forEach(t-> System.out.println());
    }

}
