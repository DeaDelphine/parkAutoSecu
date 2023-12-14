package com.assosetvous.assosetvous;

import com.assosetvous.assosetvous.entity.Role;
import com.assosetvous.assosetvous.entity.User;
import com.assosetvous.assosetvous.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class AssoSetVousApplication implements CommandLineRunner {

@Autowired
private IUserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(AssoSetVousApplication.class, args);
	}
	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		// autorisation de ma liste d'Url qui commence par http://localhost:4200, ont peut en rajouter plusieurs pour avoir plusieurs port d'autorisé
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		//Autorisation des headers contenant :
		corsConfiguration.setAllowedHeaders(Arrays.asList(
				"Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Jwt-Type", "Authorization", "Origin, Accept", "X-Request-with", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"
		));
		corsConfiguration.setExposedHeaders(Arrays.asList(
				"Origin",
				"Content-Type",
				"Accept",
				"Jwt-Token",
				"Authorization",
				"Access-Control-Allow-Origin",
				"Access-Control-Allow-Origin",
				"Access-Control-Allow-Credentials"
		));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}


	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.ADMIN);

		// On vérifie si il n'y a pas de compte administrateur alors il va en créer un avec les information par défault
		if(adminAccount == null){
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder()
					.encode("admin"));
			userRepository.save(user);
		}
	}
}
