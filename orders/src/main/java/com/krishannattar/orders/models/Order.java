package com.krishannattar.orders.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    //    ORDNUM primary key, not null Long
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;


//    ORDAMOUNT double

//    ADVANCEAMOUNT double

//    CUSTCODE Long foreign key (one customer to many orders) not null

//    ORDDESCRIPTION String


}


