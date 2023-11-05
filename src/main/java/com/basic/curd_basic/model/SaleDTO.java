package com.basic.curd_basic.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SaleDTO {

    private Long id;

    @NotNull
    private String billContent;

    @NotNull
    @Size(max = 255)
    private String product;

    @NotNull
    @Size(max = 255)
    private String customer;

    @NotNull
    private Integer quantity;

    @NotNull
    private LocalDateTime saleDate;

}
