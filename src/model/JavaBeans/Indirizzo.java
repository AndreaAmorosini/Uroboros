package model.JavaBeans;

public class Indirizzo {
    private String via;
    private String via2;
    private int CAP;
    private String nazione;
    private String regione;
    private String citta;

    public void setVia(String via){
        this.via=via;
    }

    public void setVia2(String via2){
        this.via2=via2;
    }

    public void setCAP(int CAP){
        this.CAP=CAP;
    }

    public void setNazione(String nazione){
        this.nazione=nazione;
    }

    public void setRegione(String regione){
        this.regione=regione;
    }

    public void setCitta(String citta){
        this.citta=citta;
    }

    public int getCAP(){
        return CAP;
    }

    public String getVia(){
        return via;
    }

    public String getVia2(){
        return via2;
    }

    public String getNazione(){
        return nazione;
    }

    public String getRegione(){
        return regione;
    }

    public String getCitta(){
        return citta;
    }
}
