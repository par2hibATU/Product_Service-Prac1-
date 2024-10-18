package ie.atu.week3.inventory_1.Controller;


import ie.atu.week3.inventory_1.DTO.Product;
import ie.atu.week3.inventory_1.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {
    public productController(productService service) {
        this.service = service;
    }
    @Autowired
    private final productService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addprod(@RequestBody Product product){
        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return service.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return service.getProductById(id);
    }

    @GetMapping("/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category){
        return service.getProductByCategory(category);
    }

    @PutMapping("/{id}")
    public Product updateProduct(String id, @RequestBody Product product){
        return service.updatedProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProd(@PathVariable String id){
        return service.deleteProduct(id);
    }

    @GetMapping("/received")
    public String message(){
        return "Connection Established...";
    }



}
