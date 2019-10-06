package com.krishannattar.orders.models;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

//    AGENTCODE primary key, not null Long
//    AGENTNAME string
//    WORKINGAREA string
//    COMMISSION double
//    PHONE string
//    COUNTRY string
}
