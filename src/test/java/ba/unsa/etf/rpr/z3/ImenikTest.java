package ba.unsa.etf.rpr.z3;
import ba.unsa.etf.rpr.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
public class ImenikTest {
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
    public void testMockExternal(){
        Imenik i=Mockito.mock (Imenik.class);
        Mockito.when(i.dajBroj ("Nedim")).thenReturn("Nema nista");
        String test=i.dajBroj ("Nedim");
        assertEquals(test, "Nema nista");
    }
    @Test
    public void testMockInternal(){
        try {
            Map<String, TelefonskiBroj> mapa=Mockito.mock(Map.class);
            Mockito.when(mapa.get("Eldar")).thenReturn(new FiksniBroj(Grad.MOSTAR, "225-883"));
            imenik.setBrojevi((HashMap<String, TelefonskiBroj>) mapa);
            String br=imenik.dajBroj("Eldar");
            assertNotEquals(br, "833/225-883");
            assertEquals(br, "036/225-883");
        }
        catch (BrojException err){
            System.out.println(err.toString());
        }
    }
}
