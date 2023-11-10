package ba.unsa.etf.rpr;

public enum Grad {
    TRAVNIK("030"), ODZAK("031"), ZENICA("032"), SARAJEVO("033"),
    LIVNO("034"),TUZLA("035"), MOSTAR("036"),BIHAC("037"),
    GORAZDE("038"), POSUSJE("039"),BRCKO("049");

    private  String pozivniBroj;
    Grad(String pozivniBroj) { this.pozivniBroj = pozivniBroj;}
    public  static Grad izPozivnog(String pozivni){
        for(Grad g : Grad.values()) {
            if (g.getPozivniBroj() == pozivni) {
                return g;
            }
        }
        return null;
    }
    public String getPozivniBroj(){return pozivniBroj;}

}
