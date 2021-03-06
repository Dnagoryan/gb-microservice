package ru.microservice.gbcartcreater.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    @NotBlank
    private String title;
    @NotNull
    @Digits(integer = 5, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal cost;
    @PastOrPresent
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate manufactureDate;


}
