package htw.berlin.webtech.demo.persistence;

import javax.persistence.*;

@Entity(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Produkt", nullable = false)
    private String produkt;

    @Column(name = "Menge", nullable = false)
    private int menge;

    public ItemEntity(String produkt, int menge) {
        this.produkt = produkt;
        this.menge = menge;
    }

    protected ItemEntity() {}

    public long getId() {
        return id;
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
