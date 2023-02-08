package ru.horn.author.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Author {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_author_id"
    )
    @SequenceGenerator(
            name = "seq_author_id",
            sequenceName = "seq_author_id"
    )
    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
}
