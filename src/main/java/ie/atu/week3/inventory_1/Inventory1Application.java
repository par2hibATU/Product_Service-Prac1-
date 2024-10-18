package ie.atu.week3.inventory_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Inventory1Application {

    public static void main(String[] args) {
        SpringApplication.run(Inventory1Application.class, args);
    }

}
