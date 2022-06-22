package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.entity.Category;
import com.example.springsecuritydemo.entity.Product;
import com.example.springsecuritydemo.repository.CategoryRepo;
import com.example.springsecuritydemo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/systems")
public class AdminController {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;



    @GetMapping("/Products")
    public List<Product> showProducts(){
        return (List<Product>) productRepo.findAll();
    }

    @GetMapping("/Products/{productId}")
    public Product showProduct(@PathVariable int productId){
        return  productRepo.findById(productId).orElse(null);
    }


    @PostMapping("/Products")
    public Product saveCustomer(@RequestBody Product product){

        productRepo.save(product);

        return product;
    }

    @PutMapping("/Products")
    public String updateCustomer(@RequestBody Product product){
        productRepo.save(product);

        return "Product";
    }



/*    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int id, Model model){
        Product product = productRepo.findById(id).orElse(null);

        Map<Category,String> type = new LinkedHashMap<Category,String>();
        List<Category> categories = (List<Category>) categoryRepo.findAll();

        for (Category category : categories ) {
            type.put(category, category.getName());
        }
        model.addAttribute("categoryList", type );

        model.addAttribute("product", product);

        return "product-form";
    }*/

    @DeleteMapping("/Products/{productId}")
    public boolean deleteProduct(@PathVariable int productId){
        productRepo.deleteById(productId);

        return true;
    }

/*    @GetMapping("/showFormForAddCategory")
    public String showFormForAddC(Model model){
        model.addAttribute("category", new Category());

        return "category-form";
    }*/



    @GetMapping("/Categories")
    public List<Category> showCategs(){
        return (List<Category>) categoryRepo.findAll();
    }

    @GetMapping("/Categories/{categoryId}")
    public Category showCateg(@PathVariable int categoryId){
        return  categoryRepo.findById(categoryId).orElse(null);
    }



    @PutMapping("/Categories")
    public Category updateCateg(@RequestBody Category category){
        categoryRepo.save(category);

        return category;
    }

    @PostMapping("/Categories")
    public Category saveCategory(@RequestBody Category category){
        categoryRepo.save(category);

        return category;
    }

    @DeleteMapping("/Categories/{productId}")
    public boolean deleteCateg(@PathVariable int productId){
        productRepo.deleteById(productId);

        return true;
    }

















}
