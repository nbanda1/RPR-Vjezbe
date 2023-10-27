package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite broj n: ");
        int n = scanner.nextInt();
        for(int i=1;i<=n;i++){
            if(DividableBySumOfDigits(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean DividableBySumOfDigits(int n){
        int sum = SumOfDigits(n);
        return n%sum==0;
    }

    private static int SumOfDigits(int n){
        int sum =0;
        while(n>0){
            sum += n%10;
            n= n /10;
        }
        return sum;
    }
}
