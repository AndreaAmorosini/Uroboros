package model.Connection;

import model.JavaBeans.Prodotto;
import model.JavaBeans.Transazione;

import java.sql.*;
import java.util.ArrayList;

import static model.Connection.ProdottoDAO.getCategorie;

public class TransazioneDAO {

    public Transazione doRetrieveById(int Id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_transazione,username,data_transazione,spesa FROM Transazione WHERE ID_transazione=?");
            ps.setInt(1,Id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Transazione t = new Transazione();
                t.setIdTransazione(rs.getInt(1));
                t.setUsername(rs.getString(2));
                t.setData(rs.getDate(3));
                t.setSpesa(rs.getDouble(4));
                return t;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Transazione> doRetrieveAll(){
        ArrayList<Transazione> transazioni=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_transazione,username,data_transazione,spesa FROM Transazione");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transazione t=new Transazione();
                t.setIdTransazione(rs.getInt(1));
                t.setUsername(rs.getString(2));
                t.setData(rs.getDate(3));
                t.setSpesa(rs.getDouble(4));
                transazioni.add(t);
            }
            return transazioni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int doRetrieveLastId(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT MAX(ID_transazione) FROM Transazione");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int lastId=rs.getInt(1);
            return lastId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Date date,String username, double spesa) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Transazione (username,data_transazione,spesa) VALUES(?,?,?)");
            ps.setString(1,username);
            ps.setDate(2,date);
            ps.setDouble(3,spesa);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSaveProdotti(int transID,int  prodID, String username){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO Transazione_item (ID_transazione, ID_prodotto, username) VALUES (?,?,?)");
            ps.setInt(1,transID);
            ps.setInt(2,prodID);
            ps.setString(3,username);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Transazione> doRetrieveAllByUsername(String username){
        ArrayList<Transazione> transazioni=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_transazione,username,data_transazione,spesa FROM Transazione WHERE username=?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transazione t=new Transazione();
                t.setIdTransazione(rs.getInt(1));
                t.setUsername(rs.getString(2));
                t.setData(rs.getDate(3));
                t.setSpesa(rs.getDouble(4));
                transazioni.add(t);
            }
            return transazioni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Prodotto> doRetrieveProdotti(int IdTransazione){
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_Prodotto FROM Transazione_item WHERE ID_Transazione=? ");
            ps.setInt(1,IdTransazione);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int IdProdotto=rs.getInt(1);
                PreparedStatement ps1 = con.prepareStatement("SELECT ID_Prodotto, quantità_disponibile, nome_prodotto, descrizione_prodotto, prezzo FROM Prodotti WHERE ID_Prodotto=? ");
                ps1.setInt(1,IdProdotto);
                ResultSet rs1 = ps1.executeQuery();
                while(rs1.next()){
                    Prodotto p = new Prodotto();
                    p.setIDprodotto(rs1.getInt(1));
                    p.setQuantita(rs1.getInt(2));
                    p.setNomeProdotto(rs1.getString(3));
                    p.setDescrizioneProdotto(rs1.getString(4));
                    p.setPrezzoProdotto(rs1.getDouble(5));
                    p.setCategorieProdotto(getCategorie(con,IdProdotto));
                    prodotti.add(p);
                }
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDeleteProdotti(String username){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Transazione_item WHERE username=?");
            ps.setString(1,username);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDelete(String Username){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Transazione WHERE username=?");
            ps.setString(1,Username);
            ps.execute();
            doDeleteProdotti(Username);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
