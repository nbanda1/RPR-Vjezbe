package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Double> brojevi= unosBrojeva("stop");
        System.out.println("minimum: "+minimum(brojevi));
        System.out.println("maksimum: "+maksimum(brojevi));
        System.out.println("srednja vrijednost: "+ srednjaVrijednost(brojevi));
        System.out.println("standardna devijacija: "+standardDeviation(brojevi));
    }
    public static List<Double> unosBrojeva(String stop) {
        List<Double> brojevi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Unesite broj (ili '"+stop+"' za prekid unosa): ");
            String unos = scanner.nextLine();
            if (unos.equalsIgnoreCase(stop)) { break;}
            try {
                double broj = Double.parseDouble(unos);
                brojevi.add(broj);
            } catch (NumberFormatException e) {
                continue;
            }
        }
        scanner.close();
        return brojevi;
    }
    public static double minimum(List<Double> brojevi){
        double min=brojevi.get(0);
        for(Double elem:brojevi){
            if(elem<min)min=elem;
        }
        return min;
    }
    public static double maksimum(List<Double> brojevi){
        double max=brojevi.get(0);
        for(Double elem:brojevi){
            if(elem>max)max=elem;
        }
        return max;
    }
    public static double srednjaVrijednost(List<Double> brojevi){
        double suma=0;
        for(Double elem:brojevi){
            suma+=elem;
        }
        return suma/brojevi.size();
    }
    public static double standardDeviation(List<Double> brojevi){
        double suma=0;
        double srednjaVrijednost =  srednjaVrijednost(brojevi);
        for(Double elem:brojevi){
            suma+=(elem-srednjaVrijednost)*(elem-srednjaVrijednost);
        }
        return Math.sqrt(suma/brojevi.size());
    }

}