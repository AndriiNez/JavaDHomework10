package ua.homework.Client;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "Client")
@Entity
@Data
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column
    private String name;
}
