package ba.unsa.etf.rpr;

public class Osoba {
    protected String ime,prezime;

    public Osoba(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public String toString(){
        return "ime:"+ime+"\n"+"prezime:"+prezime;
    }
}
