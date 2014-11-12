package samples.springboot.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created by izeye on 2014. 11. 12..
 */
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepoistory repoistory;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repoistory.deleteAll();

        repoistory.save(new Customer("Alice", "Smith"));
        repoistory.save(new Customer("Bob", "Smith"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repoistory.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("---------------------------------------------");
        System.out.println(repoistory.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("---------------------------------------------");
        for (Customer customer : repoistory.findByLastName("Smith")) {
            System.out.println(customer);
        }
    }

}
