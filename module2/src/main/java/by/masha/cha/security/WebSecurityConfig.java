package by.masha.cha.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@ComponentScan(basePackages = {"by.masha.cha"})
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/products").permitAll()
                .antMatchers("/static/*").permitAll()
                .antMatchers("/reg*").permitAll()
                .antMatchers("/create-order-from-car-list*").permitAll()
                .antMatchers("/create-order-from-car-list*").permitAll()
//                .antMatchers(HttpMethod.POST, "/add*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/edit*").permitAll()
                .antMatchers(HttpMethod.POST, "/delete*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/list*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/create*").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/create*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/appUser-list*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/update-car*").hasRole("Admin")
                .antMatchers(HttpMethod.POST, "/update-car*").hasRole("Admin")
                .and()
                .csrf().disable()
                .formLogin();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth,
                                        @Qualifier("authService") AuthenticationService service) throws Exception {
        auth.userDetailsService(service);

    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}