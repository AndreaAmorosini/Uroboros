package model.JavaBeans;

import java.util.Date;

public class Carta {
    private int numCarta;
    private String dataDiScadenza;
    private int CSV;
    private String nomeTitolare;
    private String cognomeTitolare;

    public void setNumCarta(int numCarta){
        this.numCarta=numCarta;
    }

    public void setDataDiScadenza(String data){
        this.dataDiScadenza=data;
    }

    public void setCSV(int csv){
        this.CSV=csv;
    }

    public void setNomeTitolare(String nometitolare){
        this.nomeTitolare=nometitolare;
    }

    public void setCognomeTitolare(String cognometitolare){
        this.cognomeTitolare=cognometitolare;
    }

    public int getNumCarta(){
        return numCarta;
    }

    public int getCSV(){
        return CSV;
    }

    public String getNomeTitolare(){
        return nomeTitolare;
    }

    public String getCognomeTitolare(){
        return cognomeTitolare;
    }

    public String getDataDiScadenza(){
        return dataDiScadenza;
    }
}
