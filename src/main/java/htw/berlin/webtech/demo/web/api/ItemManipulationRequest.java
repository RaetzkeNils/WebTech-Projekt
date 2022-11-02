package htw.berlin.webtech.demo.web.api;

public class ItemManipulationRequest {

    private String produkt;
    private int menge;

    public ItemManipulationRequest(String produkt, int menge) {
        this.produkt = produkt;
        this.menge = menge;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
}

