package Lambdacalismalari;

import Lambda_MiracHOca.Lambda01;

import java.util.stream.IntStream;

public class Lambda_sorular {
    public static void main(String[] args) {
        ciftTopla(5);
        kuvvetAl(3);

    }

    //TASK 02 --> 1'den x'e kadar cift  sayilarin top??
    public static int ciftTopla(int a){
     return IntStream.rangeClosed(2,a).filter(t->t%2==0).sum();

    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
     public static int topla(int a){
     return   IntStream.iterate(2,t->t+2).limit(a).sum();
     }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int tekTopla(int b){
    return    IntStream.iterate(1,t->t+2).limit(b).sum();
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void kuvvetAl(int x){
       IntStream.iterate(2,t->t*t).limit(x).forEach(Lambda01::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void istenilensayi(int istenensayi,int kuvvet){

        IntStream.iterate(istenensayi,t->t*istenensayi).limit(kuvvet).forEach(Lambda01::yazdir);

    }
}
