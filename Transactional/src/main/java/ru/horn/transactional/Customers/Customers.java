package ru.horn.transactional.Customers;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customers")
public class Customers {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int balance;

    public Customers(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

}
