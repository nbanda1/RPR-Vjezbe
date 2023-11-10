package ba.unsa.etf.rpr;

import java.util.*;

public class Imenik {
    private HashMap<String,TelefonskiBroj> brojevi;
    public Imenik(){
        brojevi= new HashMap<String,TelefonskiBroj>();
    }
    public HashMap<String, TelefonskiBroj> getBrojevi() {
        return brojevi;
    }
    public void setBrojevi(HashMap<String, TelefonskiBroj> brojevi) {
        this.brojevi = brojevi;
    }

    public void dodaj(String ime, TelefonskiBroj broj){
        brojevi.put(ime,broj);
    }
    public String dajBroj(String ime){
        TelefonskiBroj broj= brojevi.get(ime);
        if(broj==null)return null;
        return broj.ispisi();
    }
    public  String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String,TelefonskiBroj> entry: this.brojevi.entrySet()){
            if(entry.getValue().ispisi().equals(broj.ispisi())) return entry.getKey();
        }
        return null;
    }
    public String naSlovo(char s){
        StringBuilder builder = new StringBuilder();
        int counter=1;
        for(Map.Entry<String,TelefonskiBroj> entry: this.brojevi.entrySet()) {
            if(entry.getKey().startsWith(String.valueOf(s))){
                builder.append(counter).append(". ")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue().ispisi())
                        .append(System.lineSeparator());
            }
            counter++;
        }
        return builder.toString();
    }
    public Set<String> izGrada(Grad g){
        Set<String> rez= new TreeSet<String>();
        for(Map.Entry<String,TelefonskiBroj> entry: this.brojevi.entrySet()) {
            if(jeLiIzGrada(entry.getValue(),g)) rez.add(entry.getKey());
        }
        return  rez;
    }
    private boolean jeLiIzGrada(TelefonskiBroj broj, Grad g){
        if(broj instanceof FiksniBroj) return g.equals(((FiksniBroj)broj).getGrad());
        else return false;
    }
    Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> rez=new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });
        for(Map.Entry<String,TelefonskiBroj> entry: this.brojevi.entrySet()) {
            if(jeLiIzGrada(entry.getValue(),g)) rez.add(entry.getValue());
        }
        return rez;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int counter=1;
        for(Map.Entry<String,TelefonskiBroj> entry: this.brojevi.entrySet()) {
                builder.append(counter).append(". ")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue().ispisi())
                        .append(System.lineSeparator());
            counter++;
        }
        return builder.toString();
    }
}
