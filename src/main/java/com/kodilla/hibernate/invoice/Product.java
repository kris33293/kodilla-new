package com.kodilla.hibernate.invoice;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODCUTS")
public class Product {

    private int id;
    private String name;
    private Item item;

    public Product(){

    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
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
    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
