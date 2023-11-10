package ba.unsa.etf.rpr.z2;
import ba.unsa.etf.rpr.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {
    private static Imenik imenik = new Imenik();
    @BeforeAll
    public static void setup(){
        try{
        imenik.dodaj ("Nedim", new FiksniBroj(Grad.SARAJEVO, "225-883"));
        imenik.dodaj ("Samir", new FiksniBroj (Grad.ZENICA, "225-884"));
        imenik.dodaj ("Damir", new MobilniBroj(61, "225-885"));
        }
        catch (BrojException err){
            System.out.println(err.toString());
        }
    }

    @Test
    public void dajBrojFound(){
        String broj=imenik.dajBroj ("Nedim");
        assertEquals(broj, "033/225-883");
    }
    @Test
    public void dajBrojNotFound(){
        String broj=imenik.dajBroj ("Neodim");
        assertNull(broj);
    }
    @Test
    public void dodajTestPositive(){
        TelefonskiBroj br = new MobilniBroj (61, "507-855");
        imenik.dodaj("Harun", br);
        String brojStr = imenik.dajBroj ("Harun");
        assertEquals(brojStr, "061/507-855");
    }
    @Test
    public void dodajFiksniException(){
    assertThrows (BrojException.class, ()->{new FiksniBroj(null, "123-123");});
}

}