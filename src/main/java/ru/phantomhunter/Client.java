package ru.phantomhunter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @OneToMany
    @JoinColumn(name = "sell_id")
    private List<Sell> sell;

    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private Long id;

    @Column(name = "Name Clinet")
    private String nameClient;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
}
