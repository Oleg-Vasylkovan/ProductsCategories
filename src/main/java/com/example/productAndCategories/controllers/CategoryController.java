package com.example.productAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.productAndCategories.models.Category;
import com.example.productAndCategories.models.Product;
import com.example.productAndCategories.services.CategoryService;
import com.example.productAndCategories.services.ProductService;

@Controller
public class CategoryController {
	public final CategoryService categoryService;
	public final ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService=categoryService;
		this.productService=productService;
	}
	@RequestMapping("/categories/new")
	public String index(@ModelAttribute("category")Category category) {
		return "createCategory.jsp";
	}
	@PostMapping("/category")
	public String createCategory(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		categoryService.createCategory(category);
		return "redirect:/categories/new";
	}
	@RequestMapping("/categories/{id}")
	public String show(@PathVariable("id")Long id, @ModelAttribute("categories")Category category, Model model) {
		List<Product>product=productService.allProduct();
		model.addAttribute("products", product);
		model.addAttribute("category", categoryService.getOneCategory(id));
		return "showCategory.jsp";
	}
	@PostMapping("addProduct/{id}")
    public String addCategoryToProduct(@PathVariable("id")Long productId, @RequestParam("product") Long categoryId) {
        Product product = productService.getOneProduct(productId);
        Category category = categoryService.getOneCategory(categoryId);
        List<Category> category_product = product.getCategories();
        category_product.add(category);
        productService.saveProduct(product);
        return "redirect:/categories/" + categoryId;
	}
	
}
