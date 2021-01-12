package model.JavaBeans;

import java.util.List;

public class Categoria {

    private int IDCategoria;
    private String nomeCategoria;
    private String descrizioneCategoria;
    private List<Prodotto> prodotti;

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public int getIDCategoria() {
        return IDCategoria;
    }

    public void setIDCategoria(int IDCategoria) {
        this.IDCategoria = IDCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescrizioneCategoria() {
        return descrizioneCategoria;
    }

    public void setDescrizioneCategoria(String descrizioneCategoria) {
        this.descrizioneCategoria = descrizioneCategoria;
    }
}
