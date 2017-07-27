package org.fyp.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("oisr").password("oisin").roles("RETAILER").and()
                .withUser("oisa").password("oisin").roles("ADMIN").and()
                .withUser("oism").password("oisin").roles("MOBILE");

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()    // Authorise all requests
                .anyRequest()           // any requests
                .fullyAuthenticated()
//                .permitAll()            // Permit all
                .and().httpBasic();     // Http Basic authentication
        httpSecurity.csrf().disable(); // disable cross site security ... both apps running from same device

    }
}

