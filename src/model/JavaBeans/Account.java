package model.JavaBeans;

import java.util.Objects;

public class Account {
    private String username;
    private String password;
    private int CF;
    private  String nomeAzienda;
    private int numCarta;
    private int IDTransazione;
    private String indirizzo;
    private boolean admin;

    public void setUsername(String Username){
        this.username=Username;
    }

    public void setPassword(String Password){
        this.password=Password;
    }

    public void setCF(int CF){
        this.CF=CF;
    }

    public void setNomeAzienda(String NomeAzienda){
        this.nomeAzienda=NomeAzienda;
    }

    public void setNumCarta(int NumCarta){
        this.numCarta=NumCarta;
    }

    public void setIDTransazione(int IDTransazione){
        this.IDTransazione=IDTransazione;
    }

    public void setIndirizzo(String Indirizzo){
        this.indirizzo=Indirizzo;
    }

    public void setAdmin(boolean Admin){this.admin=Admin;}

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getCF(){
        return CF;
    }

    public String getNomeAzienda(){
        return nomeAzienda;
    }

    public int getNumCarta(){
        return numCarta;
    }

    public int getIDTransazione(){
        return IDTransazione;
    }

    public String getIndirizzo(){
        return indirizzo;
    }

    public boolean isAdmin(){return admin;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return CF == account.CF &&
                numCarta == account.numCarta &&
                IDTransazione == account.IDTransazione &&
                admin == account.admin &&
                Objects.equals(username, account.username) &&
                Objects.equals(password, account.password) &&
                Objects.equals(nomeAzienda, account.nomeAzienda) &&
                Objects.equals(indirizzo, account.indirizzo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, CF, nomeAzienda, numCarta, IDTransazione, indirizzo, admin);
    }
}
