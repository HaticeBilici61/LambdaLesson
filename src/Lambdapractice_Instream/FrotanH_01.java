package Lambdapractice_Instream;

import Lambda_Integer.Utils;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class FrotanH_01 {
    public static void main(String[] args) {

    ilk30(30);
    otuzdan100dahil(100);
    ortbul(30,40);


        }

//S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim



    
    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim
    public static void ilk30(int a) {
        IntStream.range(1, a).forEach(Utils::printInsameline);

    }

    public static void otuzdan100dahil(int a) {
        //S2:  20 den 100 kadar olan sayilari (100 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)

    IntStream.rangeClosed(20,a).forEach(Utils::printInsameline);

    }

    public static void ikisayitopla(int a,int b){
        //S3 Istenen iki deger(dahil) arasindaki sayilari toplayalim
        IntStream.rangeClosed(a,b).sum();

    }

    public static OptionalDouble ortbul(int a, int b){
      return  IntStream.rangeClosed(a,b).average();

    }
    public static int kacsayivar(int a,int b){
  //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
      return  (int) IntStream.rangeClosed(a,b).filter(t->t%8==0).count();

    }

    public static int toplamBul(int a,int b){
// S7:325 ile 468 arasinda 8 e bolunen sayilarin toplamini bulalim
        return  IntStream.rangeClosed(a,b).filter(t->t%8==0).sum();

    }
    public static void bul(int a,int b){
// S8: 7 ile 15 (dahil) arasindaki tek sayilarin carpimini bulalim
        IntStream.rangeClosed(a,b).filter(t->t%2!=0).reduce(Math::multiplyExact);
       IntStream.rangeClosed(a,b).filter(t->t%2!=0).reduce(1,(x,y)->x*y);

    }
    // S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void yedininKatlari(int a){
        IntStream.iterate(21,t->t+7).
                filter(t->t%2!=0).limit(10).
                forEach(Utils::printInsameline);

        //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim

}
}