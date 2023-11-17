package org.example;

public abstract class LicneInformacije implements Ispis{
    private String ime, prezime;

    public LicneInformacije() {
        this.ime="";
        this.prezime="";
    }

    public LicneInformacije(String ime, String prezime) {
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

}
