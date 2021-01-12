package model.JavaBeans;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.LinkedHashMap;


public class Carrello {

    private LinkedHashMap<Integer,ProdottoQuantita> prodotti = new LinkedHashMap<>();

    public static class ProdottoQuantita{
        private Prodotto prodotto;
        private int quantita;

        public ProdottoQuantita(Prodotto prodotto, int quantita){
            this.prodotto=prodotto;
            this.quantita=quantita;
        }

        public int getQuantita(){
            return quantita;
        }

        public void setQuantita(int quantita){
            this.quantita=quantita;
        }

        public Prodotto getProdotto(){
            return prodotto;
        }

        public double getPrezzoTot(){
            return quantita * prodotto.getPrezzoProdotto();
        }
    }


    public Collection<ProdottoQuantita> getProdotti(){
        return prodotti.values();
    }

    public ProdottoQuantita get(int prodID){
        return prodotti.get(prodID);
    }

    public void put(Prodotto prodotto, int quantita){
        prodotti.put(prodotto.getIDprodotto(),new ProdottoQuantita(prodotto,quantita));
    }

    public ProdottoQuantita remove(int prodID){
        return prodotti.remove(prodID);
    }

    public String getPrezzoTot(){
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        double prezzoTot = prodotti.values().stream().mapToDouble(p -> p.getPrezzoTot()).sum();
        return numberFormat.format(prezzoTot);
    }
}
