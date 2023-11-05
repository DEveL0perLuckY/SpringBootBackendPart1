package com.basic.curd_basic.service;

import com.basic.curd_basic.domain.Sale;
import com.basic.curd_basic.model.SaleDTO;
import com.basic.curd_basic.repos.SaleRepository;
import com.basic.curd_basic.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(final SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<SaleDTO> findAll() {
        final List<Sale> sales = saleRepository.findAll(Sort.by("id"));
        return sales.stream()
                .map(sale -> mapToDTO(sale, new SaleDTO()))
                .toList();
    }

    public SaleDTO get(final Long id) {
        return saleRepository.findById(id)
                .map(sale -> mapToDTO(sale, new SaleDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final SaleDTO saleDTO) {
        final Sale sale = new Sale();
        mapToEntity(saleDTO, sale);
        return saleRepository.save(sale).getId();
    }

    public void update(final Long id, final SaleDTO saleDTO) {
        final Sale sale = saleRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(saleDTO, sale);
        saleRepository.save(sale);
    }

    public void delete(final Long id) {
        saleRepository.deleteById(id);
    }

    private SaleDTO mapToDTO(final Sale sale, final SaleDTO saleDTO) {
        saleDTO.setId(sale.getId());
        saleDTO.setBillContent(sale.getBillContent());
        saleDTO.setProduct(sale.getProduct());
        saleDTO.setCustomer(sale.getCustomer());
        saleDTO.setQuantity(sale.getQuantity());
        saleDTO.setSaleDate(sale.getSaleDate());
        return saleDTO;
    }

    private Sale mapToEntity(final SaleDTO saleDTO, final Sale sale) {
        sale.setBillContent(saleDTO.getBillContent());
        sale.setProduct(saleDTO.getProduct());
        sale.setCustomer(saleDTO.getCustomer());
        sale.setQuantity(saleDTO.getQuantity());
        sale.setSaleDate(saleDTO.getSaleDate());
        return sale;
    }

}
