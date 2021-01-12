package model.Connection;

import model.JavaBeans.Categoria;
import model.JavaBeans.Prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public ArrayList<Categoria> doRetrieveAll(){
        ArrayList<Categoria> categorie=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT idCategoria,nomeCategoria,descrizioneCategoria FROM Categorie");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria c=new Categoria();
                c.setIDCategoria(rs.getInt(1));
                c.setNomeCategoria(rs.getString(2));
                c.setDescrizioneCategoria(rs.getString(3));
                categorie.add(c);
            }
            return categorie;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Categoria doRetrieveByName(String nomeCategoria){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT idCategoria,nomeCategoria,descrizioneCategoria FROM Categorie WHERE nomeCategoria=? ");
            ps.setString(1,nomeCategoria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria c=new Categoria();
                c.setIDCategoria(rs.getInt(1));
                c.setNomeCategoria(rs.getString(2));
                c.setDescrizioneCategoria(rs.getString(3));
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(int IDCategoria, String nomeCategoria, String descrizioneCategoria){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Categorie (idCategoria,nomeCategoria,descrizioneCategoria) VALUES(?,?,?)");
            ps.setInt(1,IDCategoria);
            ps.setString(2,nomeCategoria);
            ps.setString(3,descrizioneCategoria);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Categoria doRetrieveByID(int idCategoria){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT idCategoria,nomeCategoria,descrizioneCategoria FROM Categorie WHERE idCategoria=? ");
            ps.setInt(1,idCategoria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria c=new Categoria();
                c.setIDCategoria(rs.getInt(1));
                c.setNomeCategoria(rs.getString(2));
                c.setDescrizioneCategoria(rs.getString(3));
                c.setProdotti(getProdotti(con,idCategoria));
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Prodotto> getProdotti(Connection con, int id) throws SQLException{
        PreparedStatement ps = con.prepareStatement("SELECT Prodotti.ID_Prodotto,quantità_disponibile,nome_prodotto,descrizione_prodotto,prezzo FROM Prodotti LEFT JOIN Categoria_prodotti ON Prodotti.ID_prodotto = Categoria_prodotti.ID_Prodotto WHERE Categoria_prodotti.ID_categoria = ?");
        ps.setInt(1,id);
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Prodotto p = new Prodotto();
            p.setIDprodotto(rs.getInt(1));
            p.setQuantita(rs.getInt(2));
            p.setNomeProdotto(rs.getString(3));
            p.setDescrizioneProdotto(rs.getString(4));
            p.setPrezzoProdotto(rs.getDouble(5));
            prodotti.add(p);
        }
        return prodotti;
    }

    public void doDelete(int IDCategoria){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Categorie WHERE idCategoria=?");
            ps.setInt(1,IDCategoria);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(int IDCategoria, String nomeCategoria, String descrizioneCategoria){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE Categorie SET nomeCategoria=?,descrizioneCategoria=? WHERE idCategoria=?");
            ps.setString(1,nomeCategoria);
            ps.setString(2,descrizioneCategoria);
            ps.setInt(3,IDCategoria);
            ps.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
