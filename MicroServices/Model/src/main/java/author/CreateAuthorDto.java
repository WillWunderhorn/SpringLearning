package author;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAuthorDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;
}
