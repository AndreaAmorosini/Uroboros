package model.JavaBeans;

import model.JavaBeans.Categoria;

import java.util.List;

public class Prodotto {

    private int IDprodotto;
    private int quantita;
    private String nomeProdotto;
    private String descrizioneProdotto;
    private double prezzoProdotto;
    private List<Categoria> categorieProdotto;

    public List<Categoria> getCategorieProdotto() {
        return categorieProdotto;
    }

    public void setCategorieProdotto(List<Categoria> categorieProdotto) {
        this.categorieProdotto = categorieProdotto;
    }

    public int getIDprodotto() {
        return IDprodotto;
    }

    public void setIDprodotto(int IDprodotto) {
        this.IDprodotto = IDprodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public String getDescrizioneProdotto() {
        return descrizioneProdotto;
    }

    public void setDescrizioneProdotto(String descrizioneProdotto) {
        this.descrizioneProdotto = descrizioneProdotto;
    }

    public double getPrezzoProdotto() {
        return prezzoProdotto;
    }

    public void setPrezzoProdotto(double prezzoProdotto) {
        this.prezzoProdotto = prezzoProdotto;
    }
}
