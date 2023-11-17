package org.example;

public class Predmet implements Ispis{
    private String naziv, opis;

    public Predmet(String naziv, String opis) {
        this.naziv = naziv;
        this.opis = opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String Predstavi() {
        return getNaziv()+":"+getOpis();
    }
}
