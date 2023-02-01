package ru.horn.book;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;
    @NotEmpty
    private String desc;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @PastOrPresent
    private ZonedDateTime issueDate;
}
