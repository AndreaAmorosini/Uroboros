package model.Connection;

import model.Connection.ConPool;
import model.JavaBeans.Indirizzo;

import java.sql.*;
import java.util.ArrayList;

public class IndirizzoDAO {
    public Indirizzo doRetrieveByVia(String via){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT via, CAP, via2, nazione, regione, città FROM Indirizzo WHERE via=?");
            ps.setString(1,via);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Indirizzo p = new Indirizzo();
                p.setVia(rs.getString(1));
                p.setCAP(rs.getInt(2));
                p.setVia2(rs.getString(3));
                p.setNazione(rs.getString(4));
                p.setRegione(rs.getString(5));
                p.setCitta(rs.getString(6));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Indirizzo indirizzo) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Indirizzo (via, CAP, via2, nazione, regione, città) VALUES(?,?,?,?,?,?)");
            ps.setString(1, indirizzo.getVia());
            ps.setInt(2, indirizzo.getCAP());
            ps.setString(3, indirizzo.getVia2());
            ps.setString(4,indirizzo.getNazione());
            ps.setString(5,indirizzo.getRegione());
            ps.setString(6,indirizzo.getCitta());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Indirizzo> doRetrieveAll(){
        ArrayList<Indirizzo> indirizzi=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT via, CAP, via2, nazione, regione, città FROM Indirizzo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Indirizzo p = new Indirizzo();
                p.setVia(rs.getString(1));
                p.setCAP(rs.getInt(2));
                p.setVia2(rs.getString(3));
                p.setNazione(rs.getString(4));
                p.setRegione(rs.getString(5));
                p.setCitta(rs.getString(6));
                indirizzi.add(p);
            }
            return indirizzi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doDelete(String via){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Indirizzo WHERE via=?");
            ps.setString(1,via);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void doUpdate(String originalVia, String via,int CAP, String via2, String nazione, String regione, String citta){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE Indirizzo SET via=?,CAP=?,via2=?,nazione=?,regione=?,città=? WHERE via=?");
            ps.setString(1,via);
            ps.setInt(2,CAP);
            ps.setString(3,via2);
            ps.setString(4,nazione);
            ps.setString(5,regione);
            ps.setString(6,citta);
            ps.setString(7,originalVia);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
