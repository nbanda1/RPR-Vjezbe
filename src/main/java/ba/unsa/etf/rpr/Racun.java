package ba.unsa.etf.rpr;

public class Racun {
    private  long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private double stanjeRacuna;

    public Racun(long brojRacuna, Osoba korisnikRacuna) {
        this.brojRacuna = brojRacuna;
        this.korisnikRacuna = korisnikRacuna;
        this.odobrenjePrekoracenja=false;
        this.stanjeRacuna=0;
    }
    public boolean provjeriOdobrenjePrekoracenja(){return odobrenjePrekoracenja;}
    public boolean izvrsiUplatu(double uplata){stanjeRacuna+=uplata;return true;}
    public boolean izvrsiIplatu(double isplata){if(stanjeRacuna>=isplata){
        stanjeRacuna-=isplata;
        return true;
    }
    else return false;
    }
    public void odobriPrekoracenje(){odobrenjePrekoracenja=true;}


}
