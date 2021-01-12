package model.JavaBeans;

import java.util.Date;

public class Contact {
    private String nome;
    private String cognome;
    private int CF;
    private String telefono;
    private String dataDiNascita;
    private String email;

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setCognome(String cognome){
        this.cognome=cognome;
    }

    public void setCF(int CF){
        this.CF=CF;
    }

    public void setTelefono(String telefono){
        this.telefono=telefono;
    }

    public void setDataDiNascita(String data){
        this.dataDiNascita=data;
    }

    public void setEmail(String mail){
        this.email=mail;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getEmail(){
        return email;
    }

    public int getCF(){
        return CF;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getDataDiNascita(){
        return dataDiNascita;
    }
}
