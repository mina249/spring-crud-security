package com.mina.customer.crud.securityconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomerConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails mina = User.builder()
                .username("Mina")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        UserDetails ahmed = User.builder()
                .username("Ahmed")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails yehia = User.builder()
                .username("Yehia")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(mina,ahmed,yehia);
    }

   /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure.anyRequest().authenticated()
         )
                .formLogin(form->
                        form.loginPage("/loginPage")
                                .loginProcessingUrl("/authenticateUser")
                                .permitAll()
                        );
        return http.build();
    }*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/loginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                );

        return http.build();
    }
}
