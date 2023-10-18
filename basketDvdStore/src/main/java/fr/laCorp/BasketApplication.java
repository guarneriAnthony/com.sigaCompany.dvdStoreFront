package fr.laCorp;

import fr.laCorp.services.BasketService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * The type Basket application.
 */
@SpringBootApplication
public class BasketApplication {
    private final BasketService basketService;

    /**
     * Instantiates a new Basket application.
     *
     * @param basketService the basket service
     */
    public BasketApplication(BasketService basketService){
        this.basketService = basketService;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BasketApplication.class, args);
        BasketApplication application = context.getBean(BasketApplication.class);


        application.basketService.calculate(1);

}



}