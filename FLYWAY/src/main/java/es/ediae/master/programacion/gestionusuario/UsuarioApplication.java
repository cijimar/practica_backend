package es.ediae.master.programacion.gestionusuario;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "API Práctica Backend",
				version = "1.9x",
				description = "Documentación manual de la API REST para la práctica final de Backend. " +
						"Esta API se encarga de gestionar los usuarios, incluyendo operaciones CRUD y autenticación."
		)
)
@SpringBootApplication
public class UsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}

}
