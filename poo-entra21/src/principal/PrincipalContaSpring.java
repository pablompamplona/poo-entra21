package principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import controller.ContaFisicaController;

@SpringBootApplication
@ComponentScan(basePackages = "controller")
public class PrincipalContaSpring {

	public static void main(String[] args) {
		SpringApplication.run(PrincipalContaSpring.class, args);
	}

}
