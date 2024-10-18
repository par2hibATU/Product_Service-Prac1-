package ie.atu.week3.inventory_1.Repository;

import ie.atu.week3.inventory_1.DTO.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface productRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category);
}
