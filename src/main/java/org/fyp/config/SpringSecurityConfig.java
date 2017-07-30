package org.fyp.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


import org.fyp.Service.CustomUserDetailsService;
import org.fyp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
@EnableWebSecurity // This annotation brings in Spring Security
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    //     Overriding the implementation of the HTTP security.
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();
//                .and()
//                .authorizeRequests()
//                    .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
//                .anyRequest()
//                .authenticated();

        http.csrf().disable();

//                .antMatchers("**").authenticated()
//                .anyRequest().permitAll();
        // .and().formLogin().permitAll(); // you can add in a custom login page here with .loginPage("/loginpage")
        // formLogin() is SpringSecurity's default login page.
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }


}
