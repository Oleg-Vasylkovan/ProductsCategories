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
public class ProductController {
	public final ProductService productService;
	public final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService=productService;
		this.categoryService=categoryService;
	}
	@RequestMapping("/products/new")
	public String index(@ModelAttribute("product")Product product) {
		return "createProduct.jsp";		
	}
	@PostMapping("/product")
	public String createProduct(@Valid @ModelAttribute("product")Product product, BindingResult result) {
		productService.createProduct(product);
		return "redirect:/products/new";
	}
	
	@RequestMapping("/products/{id}")
	public String show(@PathVariable("id")Long id, @ModelAttribute("products")Product product, Model model ) {
		List<Category>category=categoryService.allCategory();
		model.addAttribute("categories", category);
		model.addAttribute("product", productService.getOneProduct(id));
		return "showProduct.jsp";
	}
	@PostMapping("addCategory/{id}")
    public String addProductToCat(@PathVariable("id")Long productId, @RequestParam("category") Long categoryId) {
        Category category = categoryService.getOneCategory(categoryId);
        Product product = productService.getOneProduct(productId);
        List<Product> product_cats = category.getProducts();
        product_cats.add(product);
        categoryService.saveCategory(category);
        return "redirect:/products/" + productId;
	}
}

