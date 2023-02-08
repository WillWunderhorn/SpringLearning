package author;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"name", "surname"})
public class AuthorDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;
}
