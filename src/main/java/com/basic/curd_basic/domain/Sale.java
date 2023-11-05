package com.basic.curd_basic.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Sale extends Bill {

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private String customer;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private LocalDateTime saleDate;

}
