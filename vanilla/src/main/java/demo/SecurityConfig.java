package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    TosFilter rolesFilter;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .addFilterAfter(rolesFilter, AbstractPreAuthenticatedProcessingFilter.class)
                .csrf().disable()
                .authorizeRequests().anyRequest().permitAll();
    }
}