package com.basic.curd_basic.repos;

import com.basic.curd_basic.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SaleRepository extends JpaRepository<Sale, Long> {
}
