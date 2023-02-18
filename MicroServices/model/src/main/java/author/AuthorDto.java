package author;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
