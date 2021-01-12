package model.Connection;

import model.Connection.ConPool;
import model.JavaBeans.Contact;

import java.sql.*;
import java.util.ArrayList;

public class ContactDAO {
    public Contact doRetrieveByCF(int CF){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT CF, nome, cognome, data_di_nascita, telefono, mail FROM Contact WHERE CF=?");
            ps.setInt(1,CF);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Contact p = new Contact();
                p.setCF(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setDataDiNascita(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setEmail(rs.getString(6));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Contact contact) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Contact (CF, nome, cognome, data_di_nascita, telefono, mail) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, contact.getCF());
            ps.setString(2, contact.getNome());
            ps.setString(3, contact.getCognome());
            ps.setString(4, contact.getDataDiNascita());
            ps.setString(5,contact.getTelefono());
            ps.setString(6,contact.getEmail());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Contact> doRetrieveAll(){
        ArrayList<Contact> contacts=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT CF, nome, cognome, data_di_nascita, telefono, mail FROM Contact");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contact p = new Contact();
                p.setCF(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setDataDiNascita(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setEmail(rs.getString(6));
                contacts.add(p);
            }
            return contacts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doDelete(int CF){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Contact WHERE CF=?");
            ps.setInt(1,CF);
            ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void doUpdate(int originalCF, int CF, String nome, String cognome, String dataDiNascita, String telefono, String mail){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE Contact SET CF=?, nome=?,cognome=?,data_di_nascita=?,telefono=?,mail=? WHERE CF=?");
            ps.setInt(1,CF);
            ps.setString(2,nome);
            ps.setString(3,cognome);
            ps.setString(4,dataDiNascita);
            ps.setString(5,telefono);
            ps.setString(6,mail);
            ps.setInt(7,originalCF);
            ps.execute();
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
}
