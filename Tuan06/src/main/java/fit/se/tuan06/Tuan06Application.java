package fit.se.tuan06;

import com.example.tuan06.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tuan06Application implements CommandLineRunner {

    @Autowired
    private Employee employee;

    public static void main(String[] args) {
        SpringApplication.run(Tuan06Application.class, args);
    }

    @Override
    public void run(String... args) {
        employee.displayInfo();
    }
}
