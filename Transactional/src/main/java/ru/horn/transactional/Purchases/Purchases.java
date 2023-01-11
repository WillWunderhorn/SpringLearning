package ru.horn.transactional.Purchases;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase")
@Entity
@Data
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customer_id;
    private int price;

    public Purchases(Long customer_id, int price) {
        this.customer_id = customer_id;
        this.price = price;
    }
}
