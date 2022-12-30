package Lambda_MiracHOca;

import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println(topla(5));
        System.out.println(top1(5));
        System.out.println(ilkcifttop1(5));
        System.out.println(ilkcifttop2(4));
        System.out.println(ilktektop2(4));
        ilkXkuvvet(3);
        System.out.println();
        istenilenSayiXkuvvet(3,2);
        System.out.println();
        System.out.println(istenilenSayiFaktr(5));

    }
   //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan
   // bir program create ediniz.

    //Structured ile cozelim
    public static int topla(int x){
        int top=0;
        for (int i=0 ; i<=x ;i++){
            top=top+i;
        }
        return top;
    }

    //functional ile cozuyoruz

    public static int top1(int x){
      return   IntStream. //integer degerlerde bir akis saglar.
              range(1,x+1).// range(a,b)--> a dan b ye kadar(b dahil degil) int degerler akisa alindi
              sum();    //akisdan gelen degerler toplandi
    }

   //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
   public static int cifttop1(int x){
     return
        IntStream.
                range(1,x+1).//rangeClosed methodunu yazarsak eger (a,b) a ve b iki degerde dahil olarak alir
                filter(t->t%2==0).//Lambda01::ciftBul da yazabilirdik
                sum();

   }
//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
  public static int ilkcifttop1(int x){

   return
           IntStream.
           range(1,x+1).
           filter(t->t%2==0).
           limit(2).sum();

    //hocanin yeni method cozumu ile

  }
    //hocanin yeni method cozumu ile

    public static int ilkcifttop2(int x){
        return   IntStream.iterate(2,t->t+2).limit(x).sum();

    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int ilktektop2(int x){
      return   IntStream.
              iterate(1,t->t+2).// tek sayilari aliyor 1,3,5,7,9,
              limit(x).//kac tane tek sayiyi toplayacagiz
              sum(); //toplam
    }
   //TASK 05 --> 2'nin ilk pozitif x  kuvvetini ekrana yazdiran programi  create ediniz.
   public static void ilkXkuvvet(int x){

        IntStream.
                iterate(2,t->t*2).//sartimizi yazdik
                limit(x).   //siniri koyduk
                forEach(Lambda01::yazdir); //yazdirdik
   }

  //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
  public static void istenilenSayiXkuvvet(int istenenSayi,int x){

        IntStream.
                iterate(istenenSayi,t->t*istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);
  }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int istenilenSayiFaktr(int x){

     return    IntStream.
                rangeClosed(1,x).//bu x e verecegim degere kadar al ve carp demek
                reduce(1,(t,u)->t*u);

    }
}
