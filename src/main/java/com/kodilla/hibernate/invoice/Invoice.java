package com.kodilla.hibernate.invoice;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {

    private int id;
    private Item item;
    private String number;
    private List<Item> items = new ArrayList<>();


    public Invoice() {

    }

    public Invoice(int id, String number) {
        this.id = id;
        this.number = number;
    }

    @ManyToOne
    @JoinColumn(name = "ITEMLIST_ID")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name="NUMBER")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
