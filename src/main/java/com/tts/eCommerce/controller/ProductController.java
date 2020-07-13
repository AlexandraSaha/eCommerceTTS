package com.tts.eCommerce.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.service.ProductService;

@Controller
public class ProductController {
@Autowired
private ProductService productService;
@GetMapping("/product")
public String displayProductScreen(Model model){
System.out.println("****************************Display User Product Screen");
    Product product = new Product();
    model.addAttribute("product", product);
    return "product";
}

@PostMapping("/product")
public String createNewUser(@Valid Product product, BindingResult bindingResult,Model model) {
	System.out.println("*******************************Inside Save New Product");
    productService.save(product);
        model.addAttribute("successMessage", "Product has been saved successfully");
        model.addAttribute("product", new Product());
        return "product";
}

@GetMapping("/storefront/products/{productId}")
public String show(@PathVariable Long id, Model model) {
  Product product = productService.findProductById(id);
  model.addAttribute(product);
  return "storefront/product";
}
}