package com.example.demomongo.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity): Unit {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
        http.exceptionHandling().accessDeniedPage("/403")
    }

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder): Unit {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}"+"user").roles("USER")
                .and()
                .withUser("admin").password("{noop}"+"admin").roles("ADMIN")
    }
}
