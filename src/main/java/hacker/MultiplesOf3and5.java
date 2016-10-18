package hacker;

import sun.jvm.hotspot.jdi.IntegerTypeImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nipo on 7/29/16.
 */
public class MultiplesOf3and5 {

    private Scanner sc = new Scanner(System.in);
    final private long T = Integer.valueOf(sc.nextLine());
    private ArrayList<Long> sums = new ArrayList<>();

    public static void main(String[] args) {

        MultiplesOf3and5 m35 = new MultiplesOf3and5();
        m35.putSums();
        m35.printSums();

    }

    private void putSums(){
//        int i = 0;
//        while (i < T){
//            long N = Long.valueOf(sc.nextLine());
//            long sum = 0L;
//            for (long j = 3; j < N; j++) {
//                if (j % 3 == 0 || j % 5 == 0) {
//                    sum += j;
//                }
//            }
//            if (sum != 0) {
//                sums.add(sum);
//            }
//
//            i++;
//        }

//        int i = 0;
//        while (i < T){
//            long N = Long.valueOf(sc.nextLine());
//            long sum = 0L;
//
//            for(long j = 3; j < N; j += 3){
//                sum += j;
//            }
//            for (long j = 5; j < N; j += 5){
//                sum += j;
//            }
//            for (long j = 15; j < N; j += 15){
//                sum -= j;
//            }
//            sums.add(sum);
//            i++;
//        }
        int i = 0;
        while (i<T){
            long nr = Long.valueOf(sc.nextLine());
            //long sum = 0L;

            nr--;
            long x3 = nr/3;
            long x5 = nr/5;
            long x15 = nr/15;

            long sum1 = 3*x3*(x3+1);
            long sum2 = 5*x5*(x5+1);
            long sum3 = 15*x15*(x15+1);

            long sum = (sum1+sum2-sum3)/2;
            sums.add(sum);
            i++;
        }

        }


    private void printSums(){
        for (Long sum : sums) {
            System.out.println(sum);
        }
        sc.close();
    }


}
