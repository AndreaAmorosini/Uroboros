package model.JavaBeans;

import java.sql.Date;

public class Transazione {
    public int idTransazione;
    public String username;
    public Date data;
    public double spesa;

    public int getIdTransazione() {
        return idTransazione;
    }

    public void setIdTransazione(int id) {
        idTransazione = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getSpesa() {
        return spesa;
    }

    public void setSpesa(double spesa) {
        this.spesa = spesa;
    }
}
