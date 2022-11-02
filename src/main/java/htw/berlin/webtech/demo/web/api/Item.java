package htw.berlin.webtech.demo.web.api;

public class Item {

    private long id;
    private String produkt;
    private int menge;

    public Item(long id, String produkt, int menge) {
        this.id = id;
        this.produkt = produkt;
        this.menge = menge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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