package ba.unsa.etf.rpr;

public class Drzava {
    private int id;
    private String naziv;
    private String glavni_grad;

    public Drzava(int id, String naziv, String glavni_grad) {
        this.id = id;
        this.naziv = naziv;
        this.glavni_grad = glavni_grad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGlavni_grad() {
        return glavni_grad;
    }

    public void setGlavni_grad(String glavni_grad) {
        this.glavni_grad = glavni_grad;
    }
}
