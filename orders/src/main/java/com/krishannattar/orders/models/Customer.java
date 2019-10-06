package com.krishannattar.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    //    CUSTCODE primary key, not null Long
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    //    CUSTNAME String, not null
    @Column(unique = true,
    nullable = false)
    private String custname;

    //    CUSTCITY String
    private String custcity;

    //    WORKINGAREA String
    private String workingarea;

    //    CUSTCOUNTRY String
    private String custcountry;

    //    GRADE String
    private String grade;

    //    OPENINGAMT double
    private double openingamt;

    //    RECEIVEAMT double
    private double receiveamt;

    //    PAYMENTAMT double
    private double paymentamt;

    //    OUTSTANDINGAMT double
    private double outstandingamt;

    //    PHONE String
    private String phone;

    //    AGENTCODE Long foreign key (one agent to many customers) not null
    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnoreProperties("customers")
    private Agent agent;

    @OneToMany(mappedBy = "customers",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties("customer")
    private List<Order> orders = new ArrayList<>();

    public Customer(){
        //obligatory default constructor for JPA
    }



}
