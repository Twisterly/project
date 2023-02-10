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
                .antMatchers("/reg*").permitAll()
                .antMatchers("/car-list*").permitAll()
                .antMatchers("/add-filter*").permitAll()
                .antMatchers("/update-appUser*").permitAll()
                .antMatchers("/personal-info*").permitAll()
                .antMatchers("/create-order-from-car-list*").permitAll()
                .antMatchers("/order*").permitAll()
                .antMatchers("/brand-list*").hasRole("ADMIN")
                .antMatchers("/modelDetail-list*").hasRole("ADMIN")
                .antMatchers("/bodyType-list*").hasRole("ADMIN")
                .antMatchers("/fuelType-list*").hasRole("ADMIN")
                .antMatchers("/transmissionType-list*").hasRole("ADMIN")
                .antMatchers("/appUsers-list*").hasRole("ADMIN")
                .antMatchers("/allOrders-list*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/add-car*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add-car*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/add-brand*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add-brand*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/add-modelDetail*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add-modelDetail*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/add-bodyType*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add-bodyType*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/add-fuelType*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add-fuelType*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/add-transmissionType*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add-transmissionType*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/update-order*").permitAll()
                .antMatchers(HttpMethod.POST, "/update-order*").permitAll()
                .antMatchers(HttpMethod.GET, "/create*").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/create*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/appUser-list*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/update-car*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/update-car*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/reg-appUser*").permitAll()
                .antMatchers(HttpMethod.POST, "/reg-appUser*").permitAll()
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