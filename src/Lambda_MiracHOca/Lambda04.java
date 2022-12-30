package Lambda_MiracHOca;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */

    public static void main(String[] args) {

        Universite u01=new Universite("bogazici","matematik",571,93);
        Universite u02=new Universite("istanbul tk","matematik",600,81);
        Universite u03=new Universite("istanbul","hukuk",1400,71);
        Universite u04=new Universite("marmara","bilg muh",1080,77);
        Universite u05=new Universite("odtu","gemi muh",333,74);

        List<Universite> unv=new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println(matVarMi(unv));
        System.out.println();
        System.out.println(Byksirala(unv));
        System.out.println("ENbykNotOrt(unv) = " + ENbykNotOrt(unv));
        System.out.println("EnkckNotOrt(unv) = " + EnkckNotOrt(unv));

    }

      //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
      public static boolean notOrt74BykUnv(  List<Universite> unv){
          return  unv.
                  stream().
                  allMatch(t->t.getNotOrt()>74);

      }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matVarMi(  List<Universite> unv){

      return  unv.
              stream().
              anyMatch(t->t.getBolum().//objelerin bolum isimleri alindi
              toLowerCase().
              contains("matematik"));
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> Byksirala(List<Universite> unv){

       return  unv.stream().//akis saglandi
               sorted(Comparator.comparing(Universite::getOgrSayisi).//universiteler ogr.sayisina gore tersten siralandi
                 reversed()).
                 collect(Collectors.toList());//string yapisi list yapisina donusturuldu
    }

    //task4 : matematik bolumlerinin sayisini print ediniz.
    public static int Matematik(  List<Universite> unv){

     return (int)  unv.
               stream().
               filter(t->t.getBolum().contains("matematik")). //matematik bolumunu filtreledim
               count();//secilen univeriste sayisini aldim
    }

   //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static OptionalInt ENbykNotOrt(  List<Universite> unv){

      return   unv.
                stream().
                filter(t->t.getOgrSayisi()>550).
                mapToInt(t->t.getNotOrt()).
                max();
    }
      //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt EnkckNotOrt(  List<Universite> unv){
      return   unv.
              stream().
              filter(t->t.getOgrSayisi()<1050).
              mapToInt(t->t.getNotOrt()).
              min();
    }
}
