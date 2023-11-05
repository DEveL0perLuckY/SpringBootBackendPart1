package com.basic.curd_basic.controller;

import com.basic.curd_basic.model.SaleDTO;
import com.basic.curd_basic.service.SaleService;
import com.basic.curd_basic.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(final SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("sales", saleService.findAll());
        return "sale/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("sale") final SaleDTO saleDTO) {
        return "sale/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("sale") @Valid final SaleDTO saleDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "sale/add";
        }
        saleService.create(saleDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("sale.create.success"));
        return "redirect:/sales";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable final Long id, final Model model) {
        model.addAttribute("sale", saleService.get(id));
        return "sale/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable final Long id,
            @ModelAttribute("sale") @Valid final SaleDTO saleDTO, final BindingResult bindingResult,
            final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "sale/edit";
        }
        saleService.update(id, saleDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("sale.update.success"));
        return "redirect:/sales";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable final Long id, final RedirectAttributes redirectAttributes) {
        saleService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("sale.delete.success"));
        return "redirect:/sales";
    }

}
