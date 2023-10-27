import java.util.Scanner;

public class Zbir {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(("Unesi prvi broj: "));
        int broj1 = scanner.nextInt();
        System.out.print(("Unesi drugi broj: "));
        int broj2 = scanner.nextInt();
        System.out.println("Zbir ova dva broja: " + (broj1+broj2));
    }
}
