package ba.unsa.etf.rpr;
import java.util.List;
public class Banka {
    protected long brojRacuna;
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;
    public Banka(){
        brojRacuna=0;
    }
    public Korisnik kreirajNovogKorisnika(String ime,String prezime){
        return new Korisnik(ime,prezime);
    }
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        return new Uposlenik(ime,prezime);
    }
    public Racun kreirajRacunZaKorisnika(Korisnik korisnik){
        return new Racun(brojRacuna,korisnik);
    }
}
