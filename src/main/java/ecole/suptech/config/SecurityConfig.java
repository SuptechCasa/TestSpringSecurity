package ecole.suptech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
import ecole.suptech.service.UserService;

@Configuration
public class SecurityConfig {
@Autowired UserService us;

private PasswordEncoder encoder() {
	return new BCryptPasswordEncoder();
}
@Bean
DaoAuthenticationProvider daoAuthenticationProvider() {
	DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
	dap.setUserDetailsService(us);
	dap.setPasswordEncoder(encoder());
	return dap;
}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http
	 	.authorizeHttpRequests((authorizeHttpRequests) ->
	 		authorizeHttpRequests
	 			.requestMatchers("/public").permitAll()
		 		.requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
		 		.requestMatchers("/admin/**").hasRole("ADMIN")	
	 	).formLogin(withDefaults())
	 	;
	return http.build();

}

}
