package za.co.digitalplatoon.invoiceservice.invoice.srvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("za.co.digitalplatoon.invoiceservice.invoice")
@EntityScan("za.co.digitalplatoon.invoiceservice.invoice.model.entities")
@EnableJpaRepositories("za.co.digitalplatoon.invoiceservice.invoice.model.repositories")
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}
}
