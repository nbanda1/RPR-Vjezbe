package ba.unsa.etf.rpr;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) throws BrojException {
        if(grad==null)
            throw new BrojException("Neispravan broj");
        this.grad = grad;
        this.broj = broj;
    }
    @Override
    public String ispisi(){
        if(broj==null || grad==null){
            return null;
        }
        return grad.getPozivniBroj()+"/"+broj;
    }

    public Grad getGrad() {
        return grad;
    }
    public String getBroj() {
        return broj;
    }

    @Override
    public int hashCode() { return Objects.hash(grad,broj);}

}
