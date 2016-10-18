package hacker;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/*
* 31.07.2016 by nipo
* */
public class Fibo {

    private Scanner sc = new Scanner(System.in);
    final private int T = Integer.valueOf(sc.nextLine());
    ArrayList<Long> sums = new ArrayList<Long>(T);

    public void getSum(long N, ArrayList<Long> lister){
        long f1 = 1;
        long f2 = 1;
        long f = 0;
        long sum = 0;

        while (f < N) {
            f = f1+f2;
            if( f % 2 == 0 & f<N) sum += f;
            f1 = f2;
            f2 = f;
        }
        lister.add(sum);
    }

    public void printOutSums(){
        for (int u = 0; u < T; u++){
            long N = Long.valueOf(sc.nextLine()); //получаем следующие N числа
            getSum(N, sums);
        }
        for (int i = 0; i<T; i++){
            System.out.println(sums.get(i));
        }
    }

    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        fibo.printOutSums();
    }
}
