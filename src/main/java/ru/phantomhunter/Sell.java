package ru.phantomhunter;


import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "sells")
public class Sell {

    @Id
    @GeneratedValue
    @Column(name = "sell_id")
    private Long id;
//    @Column(name = "Data_sells")
//    private Data data;

    @ManyToOne()
    @JoinColumn
    private Client client;

    @ManyToMany(mappedBy = "sells",fetch = FetchType.EAGER)
    private List<Product> products;

    @Column(name = "Amount")
    private int amount;
    @Column(name = "Price")
    private double price;
}
