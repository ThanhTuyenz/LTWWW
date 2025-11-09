package fit.se.tuan06.config;

import com.example.tuan06.model.Address;
import com.example.tuan06.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Address address() {
        return new Address();
    }

    @Bean
    public Employee employee(Address address) {
        Employee e = new Employee();
        e.displayInfo();
        return e;
    }
}