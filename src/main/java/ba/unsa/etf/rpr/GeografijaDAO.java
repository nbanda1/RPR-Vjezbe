package ba.unsa.etf.rpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
        private static GeografijaDAO instance = null;
        private Connection conn;
        private void regenerisiBazu() {
            Scanner ulaz = null;
            try {
                ulaz = new Scanner(new FileInputStream("src/main/resources/baza.sql"));
                String sqlUpit = "";
                while (ulaz.hasNext()) {
                    sqlUpit += ulaz.nextLine();
                    if ( sqlUpit.length() > 1 && sqlUpit.charAt( sqlUpit.length()-1 ) == ';') {
                        try {
                            Statement stmt = conn.createStatement();
                            stmt.execute(sqlUpit);
                            sqlUpit = "";
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
                ulaz.close();
            } catch (FileNotFoundException e) {
                System.out.println("Ne postoji SQL datoteka... nastavljam sa praznom bazom");
            }
        }
        private GeografijaDAO() throws SQLException, ClassNotFoundException {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/baza.db");

            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("INSERT OR IGNORE INTO drzava (id,naziv,glavni_grad) VALUES (1,'Francuska',1)");
                stmt.executeUpdate("INSERT OR IGNORE INTO drzava (id,naziv,glavni_grad) VALUES (2,'UK',2)");
                stmt.executeUpdate("INSERT OR IGNORE INTO drzava (id,naziv,glavni_grad) VALUES (3,'Austrija',3)");
                stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (1,'Pariz',10000000,1)");
                stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (2,'London',9800000,2)");
                stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (3,'Beč',3000000,3)");
                stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (4,'Manchester',4000000,2)");
                stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (5,'Graz',2300000,3)");
            }catch(SQLException e) {
                regenerisiBazu();
                try {
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate("INSERT OR IGNORE INTO drzava (id,naziv,glavni_grad) VALUES (1,'Francuska',1)");
                    stmt.executeUpdate("INSERT OR IGNORE INTO drzava (id,naziv,glavni_grad) VALUES (2,'UK',2)");
                    stmt.executeUpdate("INSERT OR IGNORE INTO drzava (id,naziv,glavni_grad) VALUES (3,'Austrija',3)");
                    stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (1,'Pariz',10000000,1)");
                    stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (2,'London',9800000,2)");
                    stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (3,'Beč',3000000,3)");
                    stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (4,'Manchester',4000000,2)");
                    stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES (5,'Graz',2300000,3)");
                } catch(SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }

        public static GeografijaDAO getInstance() throws SQLException, ClassNotFoundException {
            if (instance == null) instance = new GeografijaDAO();
            return instance;
        }
        public static void removeInstance() throws SQLException {
                instance.conn.close();
                instance = null;
        }
        public ArrayList<Grad> gradovi() throws SQLException {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT g.id,g.naziv,g.broj_stanovnika,d.naziv FROM grad g,drzava d WHERE g.id=d.glavni_grad AND d.id=g.drzava ORDER BY broj_stanovnika DESC");
            ArrayList<Grad> g=new ArrayList<Grad>();
            while(result.next()) {
                g.add(new Grad(result.getInt(1),result.getString(2),result.getInt(3),result.getString(4)));
            }
            return g;
        }
        public Grad glavniGrad(String drzava) throws SQLException {
            Statement stmt = conn.createStatement();
            ResultSet result= stmt.executeQuery("SELECT g.id,g.naziv,g.broj_stanovnika,d.naziv FROM grad g, drzava d WHERE g.id=d.glavni_grad AND d.naziv='"+drzava+"'");
            int id=0;
            try{
            id=result.getInt(1);}
            catch(Exception e){
                return null;
            }
            String naziv=result.getString(2);
            int broj_stanovnika=result.getInt(3);
            String drzavaa=result.getString(4);
            return new Grad(id,naziv,broj_stanovnika,drzavaa);
        }

        public void obrisiDrzavu(String drzava) throws SQLException {
            Statement stmt=conn.createStatement();
            stmt.executeUpdate("DELETE g,d FROM grad g,drzava d WHERE d.naziv='"+drzava+"' AND d.id=g.drzava" );
        }

        public void dodajGrad(Grad grad) throws SQLException {
            Statement stmt=conn.createStatement();
            ResultSet result=stmt.executeQuery("SELECT d.id FROM drzava d WHERE d.naziv='"+grad.getDrzava()+"'");
            int drzava=result.getInt(1);
            stmt.executeUpdate("INSERT OR IGNORE INTO grad (id,naziv,broj_stanovnika,drzava) VALUES ("+grad.getId()+",'"+grad.getNaziv()+"',"+grad.getBroj_stanovnika()+","+drzava+")");
        }

        public void dodajDrzavu(Drzava drzava) throws SQLException {
            Statement stmt=conn.createStatement();
            ResultSet result=stmt.executeQuery("SELECT g.id FROM grad g WHERE g.naziv='"+drzava.getGlavni_grad()+"'");
            int grad=result.getInt(1);
            stmt.executeUpdate("INSERT OR IGNORE INTO drzava (id,naziv,glavni_grad) VALUES ("+drzava.getId()+",'"+drzava.getNaziv()+"',"+grad+")");
        }

        public void izmijeniGrad(Grad grad) throws SQLException {
            Statement stmt=conn.createStatement();
            ResultSet result=stmt.executeQuery("SELECT d.id FROM drzava d WHERE d.naziv='"+grad.getDrzava()+"'");
            int drzava=result.getInt(1);
            stmt.executeUpdate("UPDATE grad SET naziv='"+grad.getNaziv()+"' ,broj_stanovnika="+grad.getBroj_stanovnika()+",drzava="+drzava+" WHERE id="+grad.getId());
        }

        public Drzava nadjiDrzavu(String drzava) throws SQLException {
            Statement stmt = conn.createStatement();
            ResultSet result= stmt.executeQuery("SELECT d.id,d.naziv,g.naziv FROM grad g, drzava d WHERE d.id=g.drzava AND g.id=d.glavni_grad AND d.naziv='"+drzava+"'");
            int id=0;
            try{
                id=result.getInt(1);}
            catch(Exception e){
                return null;
            }
            String naziv=result.getString(2);
            String grad=result.getString(3);
            return new Drzava(id,naziv,grad);
        }
}
