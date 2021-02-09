package com.kodilla.hibernate.invoice;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ITEMS")
public class Item {

    private int id;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;
    private List<Product> products = new ArrayList<>();


    public Item() {

    }


    public Item(int id,  BigDecimal price, int quantity, BigDecimal value) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
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


    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "item",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Product> getProduct() {
        return products;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @NotNull
    @Column(name="PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    @Column(name="QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NotNull
    @Column(name="VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
