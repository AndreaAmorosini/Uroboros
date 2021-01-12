package model.Connection;

import model.JavaBeans.Carta;

import java.sql.*;
import java.util.ArrayList;

public class CartaDAO {
    
    public Carta doRetrieveBynumCarta(int numCarta){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT numCarta, data_di_scadenza, CSV, nome_titolare, cognome_titolare FROM Carta_di_credito WHERE numCarta=?");
            ps.setInt(1,numCarta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Carta p = new Carta();
                p.setNumCarta(rs.getInt(1));
                p.setDataDiScadenza(rs.getString(2));
                p.setCSV(rs.getInt(3));
                p.setNomeTitolare(rs.getString(4));
                p.setCognomeTitolare(rs.getString(5));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Carta carta) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Carta_di_credito (numCarta, data_di_scadenza, CSV, nome_titolare, cognome_titolare) VALUES(?,?,?,?,?)");
            ps.setInt(1, carta.getNumCarta());
            ps.setString(2, carta.getDataDiScadenza());
            ps.setInt(3, carta.getCSV());
            ps.setString(4,carta.getNomeTitolare());
            ps.setString(5,carta.getCognomeTitolare());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Carta> doRetrieveAll(){
        ArrayList<Carta> Carte=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT numCarta, data_di_scadenza, CSV, nome_titolare, cognome_titolare FROM Carta_di_credito");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Carta p = new Carta();
                p.setNumCarta(rs.getInt(1));
                p.setDataDiScadenza(rs.getString(2));
                p.setCSV(rs.getInt(3));
                p.setNomeTitolare(rs.getString(4));
                p.setCognomeTitolare(rs.getString(5));
                Carte.add(p);
            }
            return Carte;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doDelete(int numCarta){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Carta_di_credito WHERE numCarta=?");
            ps.setInt(1,numCarta);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void doUpdate(int originalNumCarta, int numCarta, String dataDiScadenza, int CSV, String nomeTitolare, String cognomeTitolare){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE Carta_di_credito SET numCarta=?, data_di_scadenza=?, CSV=?, nome_titolare=?, cognome_titolare=? WHERE numCarta=?");
            ps.setInt(1,numCarta);
            ps.setString(2,dataDiScadenza);
            ps.setInt(3,CSV);
            ps.setString(4,nomeTitolare);
            ps.setString(5,cognomeTitolare);
            ps.setInt(6,originalNumCarta);
            ps.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
