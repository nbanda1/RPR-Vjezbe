package ba.unsa.etf.rpr;

public class Main {

    public static void main(String[] args) {
        Sat s = new Sat(10,30,50);
        s.ispisi();
        s.sljedeci();
        s.ispisi();
        s.pomjeriZa(-48);
        s.ispisi();
        s.postavi(0,0,0);
        s.ispisi();
    }
}
