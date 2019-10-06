package com.krishannattar.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    //    ORDNUM primary key, not null Long
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    //    ORDAMOUNT double
    private double ordamount;

    //    ADVANCEAMOUNT double
    private double advanceamount;

    //    CUSTCODE Long foreign key (one customer to many orders) not null
    @ManyToOne
    @JoinColumn(name = "custcode",
            nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer customer;

    //    ORDDESCRIPTION String
    private String orddescription;

    public Order() {

    }

    public Order(double ordamount, double advanceamount, String orddescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orddescription = orddescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }
}


