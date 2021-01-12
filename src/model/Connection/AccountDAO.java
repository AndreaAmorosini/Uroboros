package model.Connection;

import model.JavaBeans.Account;

import java.sql.*;
import java.util.ArrayList;

public class AccountDAO {

    public Account doRetrieveByUsernameAndPassword(String Username, String password){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT username,password, CF, nome_azienda, numCarta, indirizzo, admin FROM Account WHERE username=? AND password=SHA1(?) ");
            ps.setString(1,Username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account p = new Account();
                p.setUsername(rs.getString(1));
                p.setPassword(rs.getString(2));
                if(rs.getString(4) == null)
                    p.setCF(rs.getInt(3));
                else
                    p.setNomeAzienda(rs.getString(4));
                p.setNumCarta(rs.getInt(5));
                p.setIndirizzo(rs.getString(6));
                p.setAdmin(rs.getBoolean(7));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account doRetrieveByUsername(String username){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT username,password, CF, nome_azienda, numCarta, indirizzo, admin FROM Account WHERE username=?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account p = new Account();
                p.setUsername(rs.getString(1));
                p.setPassword(rs.getString(2));
                if(rs.getString(4) == null)
                    p.setCF(rs.getInt(3));
                else
                    p.setNomeAzienda(rs.getString(4));
                p.setNumCarta(rs.getInt(5));
                p.setIndirizzo(rs.getString(6));
                p.setAdmin(rs.getBoolean(7));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Account account) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Account (username, password, CF, nome_azienda, numCarta, indirizzo) VALUES(?,SHA1(?),?,?,?,?)");
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getCF());
            ps.setString(4,account.getNomeAzienda());
            ps.setInt(5,account.getNumCarta());
            ps.setString(6,account.getIndirizzo());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Account> doRetrieveAll(){
        ArrayList<Account> accounts=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT username,password, CF, nome_azienda, numCarta, indirizzo FROM Account");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account p = new Account();
                p.setUsername(rs.getString(1));
                p.setPassword(rs.getString(2));
                if(rs.getString(4) == null)
                    p.setCF(rs.getInt(3));
                else
                    p.setNomeAzienda(rs.getString(4));
                p.setNumCarta(rs.getInt(5));
                p.setIndirizzo(rs.getString(6));
                accounts.add(p);
            }
            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(String userOriginal,String Username,String Password,int Cf,int NumCarta, String Indirizzo) {
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE Account SET username=?, password=SHA1(?), CF=?, numCarta=?, indirizzo=? WHERE username=?");
            ps.setString(1,Username);
            ps.setString(2,Password);
            ps.setInt(3,Cf);
            ps.setInt(4,NumCarta);
            ps.setString(5,Indirizzo);
            ps.setString(6,userOriginal);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDelete(String Username){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Account WHERE username=?");
            ps.setString(1,Username);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
