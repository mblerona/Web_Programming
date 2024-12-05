package mk.finki.ukim.mk.lab1_a;//package mk.finki.ukim.mk.Lab1_A;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan

public class Lab1AApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab1AApplication.class, args);
	}

}
