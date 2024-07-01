package com.TicketGest.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration{

   private DetailServiceImpl detailService;

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       System.out.println("Hello1");
       httpSecurity.userDetailsService(detailService);
       System.out.println("Hello2");
       httpSecurity
               .csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(registry -> {
                   registry.requestMatchers("/admin/**")
                           .permitAll();
                   registry.requestMatchers("/formateur/**").hasRole("formateur");
                   registry.requestMatchers("/apprenant/**").hasRole("Apprenant");


                   registry.anyRequest().authenticated();

               })
               .httpBasic(withDefaults());
       return httpSecurity.build();

  /*  return httpSecurity
               .csrf(csrf-> csrf.disable())
               .authorizeHttpRequests(registry->{
                   registry.requestMatchers("api/**").permitAll()
                           .requestMatchers("admin/**").hasRole("ADMIN")
                           .requestMatchers("article/**", " formateur").hasRole("FORMATEUR")
                           .requestMatchers("apprenant/**").hasRole("APPRENANT")
                           .anyRequest().authenticated();
               })
               .httpBasic(Customizer.withDefaults())
               .build();
   }**/
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(detailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
