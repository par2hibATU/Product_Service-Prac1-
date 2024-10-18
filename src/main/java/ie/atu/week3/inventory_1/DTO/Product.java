package ie.atu.week3.inventory_1.DTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Valid
    private String id;
    @NotNull(message="Name should not left blank and it is mandatory")
    private String name;
    @NotNull(message = "Product code is mandatory")
    private int code;
    @NotNull(message="Product Type should not left blank and it is mandatory")
    private String category;
    private int quantity;
}
