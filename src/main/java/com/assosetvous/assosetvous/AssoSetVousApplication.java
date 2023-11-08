package com.assosetvous.assosetvous;

import com.assosetvous.assosetvous.entity.Role;
import com.assosetvous.assosetvous.entity.User;
import com.assosetvous.assosetvous.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AssoSetVousApplication implements CommandLineRunner {

@Autowired
private IUserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(AssoSetVousApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.ADMIN);

		// On vérifie si il n'y a pas de compte administrateur alors il va en créer un avec les information par défault
		if(adminAccount == null){
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setFirstname("admin");
			user.setLastname("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder()
					.encode("admin"));
			userRepository.save(user);
		}
	}
}
