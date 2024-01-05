package ba.unsa.etf.rpr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{

    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        GeografijaDAO baza = GeografijaDAO.getInstance();
        ispisiGradove();
        glavniGrad();
    }
    public static void ispisiGradove() throws SQLException, ClassNotFoundException {
        GeografijaDAO baza = GeografijaDAO.getInstance();
        ArrayList<Grad> g=baza.gradovi();
        for(int i=0;i<g.size();i++){
            Grad temp=g.get(i);
            System.out.println(temp.getNaziv()+" ("+temp.getDrzava()+") - "+temp.getBroj_stanovnika());
        }
    }
    public static void glavniGrad() throws SQLException, ClassNotFoundException {
        GeografijaDAO baza = GeografijaDAO.getInstance();
        System.out.println("Unesi ime drzave: ");
        Scanner ulaz=new Scanner(System.in);
        String drzava=ulaz.nextLine();
        Grad grad=baza.glavniGrad(drzava);
        if(grad==null){
            System.out.println("Nepostojeca drzava");
        }
        else{
            System.out.println("Glavni grad "+drzava+" je "+grad.getNaziv());
        }
    }
}
