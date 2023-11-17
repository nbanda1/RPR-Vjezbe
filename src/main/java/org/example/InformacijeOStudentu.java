package org.example;

public class InformacijeOStudentu extends LicneInformacije{
    private String godinaStudija, brojIndeksa;

    public InformacijeOStudentu(String ime, String prezime, String godinaStudija, String brojIndeksa) {
        super(ime, prezime);
        this.godinaStudija = godinaStudija;
        this.brojIndeksa = brojIndeksa;
    }

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    @Override
    public String Predstavi() {
        return getIme()+":"+getPrezime()+":"+getGodinaStudija()+":"+getBrojIndeksa();
    }
}
