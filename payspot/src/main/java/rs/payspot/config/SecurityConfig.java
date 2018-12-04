package rs.payspot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;




@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${allowed.origin}")
	private String allowedOrigin;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")
				.password("password").roles("USER", "ADMIN");
	}
	

	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers(HttpMethod.GET, "/{email}/payment").permitAll()
		.anyRequest().authenticated().and().httpBasic();*/
		http.authorizeRequests().antMatchers("/**").permitAll()
		.anyRequest().authenticated().and().httpBasic();
		http.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.headers().frameOptions().disable();
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        List<String> origins = new ArrayList<String>();
        //origins.add("https://api.ccbill.com/wap-frontflex/flexforms/6aa83b3d-8264-4e80-a350-7824b5005e52");
        origins.add(allowedOrigin);
		config.setAllowedOrigins(origins);
		//config.addAllowedOrigin("http://www.yahoo.com");
		config.addAllowedHeader("*");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("OPTIONS");
		 final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
        return source;
    }
	
	
	

}

