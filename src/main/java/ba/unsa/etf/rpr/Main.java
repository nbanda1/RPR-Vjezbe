package ba.unsa.etf.rpr;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        System.out.println("sinus: "+Math.sin(Integer.parseInt(args[0])));
        System.out.println("Faktorijel: "+ Faktorijel(Integer.parseInt(args[0])));
    }

    static int Faktorijel(int n){
        int rez=1;
        for(int i=2;i<=n;i++){
            rez*=i;
        }
        return rez;
    }
}