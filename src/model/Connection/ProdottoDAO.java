package model.Connection;

import model.Connection.ConPool;
import model.JavaBeans.Categoria;
import model.JavaBeans.Prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {


    public Prodotto doRetrieveByID(int IDProdotto){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_Prodotto, quantità_disponibile, nome_prodotto, descrizione_prodotto, prezzo FROM Prodotti WHERE ID_Prodotto=? ");
            ps.setInt(1,IDProdotto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p=new Prodotto();
                p.setIDprodotto(rs.getInt(1));
                p.setQuantita(rs.getInt(2));
                p.setNomeProdotto(rs.getString(3));
                p.setDescrizioneProdotto(rs.getString(4));
                p.setPrezzoProdotto(rs.getDouble(5));
                p.setCategorieProdotto(getCategorie(con,IDProdotto));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Prodotto> doRetrieveAll(int offset, int limit){
        ArrayList<Prodotto> prodotti=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ID_Prodotto,quantità_disponibile,nome_prodotto,descrizione_prodotto,prezzo FROM Prodotti LIMIT ?,?");
            ps.setInt(1,offset);
            ps.setInt(2,limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p=new Prodotto();
                p.setIDprodotto(rs.getInt(1));
                p.setQuantita(rs.getInt(2));
                p.setNomeProdotto(rs.getString(3));
                p.setDescrizioneProdotto(rs.getString(4));
                p.setPrezzoProdotto(rs.getDouble(5));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(int prodID,String nome, String descrizione , Double prezzo,int quantita){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Prodotti (ID_Prodotto,quantità_disponibile,nome_prodotto,descrizione_prodotto,prezzo) VALUES(?,?,?,?,?)");
            ps.setInt(1,prodID);
            ps.setInt(2,quantita);
            ps.setString(3,nome);
            ps.setString(4,descrizione);
            ps.setDouble(5,prezzo);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSaveCategoria(int prodID, int catID){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO Categoria_prodotti(ID_prodotto, ID_categoria) VALUES (?,?)");
            ps.setInt(1,prodID);
            ps.setInt(2,catID);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    static List<Categoria> getCategorie(Connection con, int idprodotto) throws SQLException{
        PreparedStatement ps = con.prepareStatement("SELECT idCategoria,nomeCategoria,descrizioneCategoria FROM Categorie LEFT JOIN Categoria_prodotti ON idCategoria = ID_categoria WHERE ID_prodotto=?");
        ps.setInt(1,idprodotto);
        ArrayList<Categoria> categorie = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Categoria c = new Categoria();
            c.setIDCategoria(rs.getInt(1));
            c.setNomeCategoria(rs.getString(2));
            c.setDescrizioneCategoria(rs.getString(3));
            categorie.add(c);
        }
        return categorie;
    }

    public List<Prodotto> getProdottiByNameLikeness(String name){
        ArrayList<Prodotto> prodotti=new ArrayList<>();
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT ID_Prodotto,quantità_disponibile,nome_prodotto,descrizione_prodotto,prezzo FROM Prodotti WHERE nome_prodotto LIKE ?");
            ps.setString(1,"%" + name + "%");
            ResultSet rs=ps.executeQuery();
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
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(int prodID,String nome, String descrizione, Double prezzo, int quantita){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE Prodotti SET nome_prodotto=?, descrizione_prodotto=?,prezzo=?,quantità_disponibile=? WHERE ID_Prodotto=?");
            ps.setString(1,nome);
            ps.setString(2,descrizione);
            ps.setDouble(3,prezzo);
            ps.setInt(4,quantita);
            ps.setInt(5,prodID);
            ps.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDelete(int prodID){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Prodotti WHERE ID_Prodotto=?");
            ps.setInt(1,prodID);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDeleteCategoria(int prodID){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Categoria_prodotti WHERE ID_prodotto=?");
            ps.setInt(1,prodID);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

