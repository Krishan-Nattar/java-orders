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

    public Order()
    {

    }


}


