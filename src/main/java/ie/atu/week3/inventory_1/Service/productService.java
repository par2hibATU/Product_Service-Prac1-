package ie.atu.week3.inventory_1.Service;

import ie.atu.week3.inventory_1.DTO.Product;
import ie.atu.week3.inventory_1.Repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class productService {
    @Autowired
    private productRepository repository;

    public Product addProduct(Product product){
        product.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(product);
    }
    //note this
    public List<Product> findAllProducts(){
        return repository.findAll();
    }

    public List<Product> getProductByCategory(String category){
        return repository.findByCategory(category);
    }

    public Product getProductById(String id){
        return repository.findById(id).get();
    }

    public Product updatedProduct(String id, Product product){
        Optional<Product> queryProd = repository.findById(id);
        if(!queryProd.isPresent()){
            throw new RuntimeException("Product is not available in the inventory");
        }
        Product existingProduct = queryProd.get();
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setCode(product.getCode());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

    public boolean deleteProduct(String id){
        Optional<Product> existingProd = repository.findById(id);
        if(!existingProd.isPresent()){
            throw new RuntimeException("Product is not available in the inventory");
        }
        repository.deleteById(id);
        return true;
    }

}
