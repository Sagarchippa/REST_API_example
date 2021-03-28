package com.example.REST_API_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*
        //IN-MEMORY AUTHENTICATION (HARD-CODED)
                 auth.inMemoryAuthentication().withUser("sagar").password("rgukt123").roles("USER").and()
                .withUser("rgukt").password("sagar123").roles("ADMIN");
         */

        //JPA AUTHENTICATION
        auth.userDetailsService(userDetailsService);

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
         http.authorizeRequests().antMatchers("/watch_movie").hasAnyRole("USER","ADMIN")
         .and()
         .antMatchers("/user").hasRole("USER")
         .and()
         .antMatchers("/admin").hasRole("ADMIN")
         .and()
         .formLogin();
         */
        http.authorizeRequests().antMatchers("/admin")
                .hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
