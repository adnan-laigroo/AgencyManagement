package com.magic.project.configuration;

import com.magic.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
//    	http.cors();
   	http
        .cors()
            .and()
        .authorizeRequests()
        .antMatchers("/management/Agency/**", "/management/Worker/**" , "/management/user/**").hasRole("Admin")
        .antMatchers("/management/Worker/**").hasAnyRole("Agency")
        .antMatchers(HttpMethod.POST, "/management/Agency/add", "/management/Worker/add/**").hasRole("Admin")
        .antMatchers(HttpMethod.DELETE, "/management/Agency/delete", "/management/Woker/delete").hasAnyRole("Admin","Agency")
        .antMatchers(HttpMethod.DELETE,  "/management/Woker/delete").hasAnyRole("Admin","Agency")
        .antMatchers(HttpMethod.POST, "/management/Worker/add/**").hasAnyRole("Admin", "Agency")
        .antMatchers(HttpMethod.PATCH,"/management/user/update/password/**").hasAnyRole("Agency", "Admin")
        .antMatchers(HttpMethod.PUT, "/management/Agency/update/**", "/management/Worker/update/**").hasRole("Admin")
        .antMatchers(HttpMethod.PUT, "/management/Worker/update/**").hasAnyRole("Admin","Agency")
            // Configure your request mappings and authorization rules
            .anyRequest().fullyAuthenticated()
            .and().httpBasic();    
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder()).and()
        .inMemoryAuthentication().withUser("Admin").password(passwordEncoder().encode("Admin@1234")).roles("Admin"); 
    }
    
    
}
