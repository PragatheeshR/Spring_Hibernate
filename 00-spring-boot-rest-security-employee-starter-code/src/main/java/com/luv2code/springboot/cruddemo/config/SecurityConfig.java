package com.luv2code.springboot.cruddemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {


    //to use custom table name and columns instead of default one's

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager =  new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return  jdbcUserDetailsManager;
    }





    //add support for JDBC.. no more hard coding users as done in commented code

    /* Below is using default table structure
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        //telling spring to use JBDC auth with our data source
        return new JdbcUserDetailsManager(dataSource);

    }
    /*
     */



    // below code os for configuring security info directly in code
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                                    configurer
                                            .requestMatchers(HttpMethod.GET, "api/employees").hasRole("EMPLOYEE")
                                            .requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")
                                            .requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
                                            .requestMatchers(HttpMethod.PUT, "api/employees").hasRole("MANAGER")
                                            .requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN"));

        // to use HTTP basic Authentication
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());

       return httpSecurity.build();
    }

        /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails praga = User.builder().
                                 username("praga").
                                 password("{noop}praga").
                                 roles("EMPLOYEE").build();

        UserDetails thanigai = User.builder().
                username("thanigai").
                password("{noop}thanigai").
                roles("EMPLOYEE", "MANAGER").build();

        UserDetails megala = User.builder().
                username("megala").
                password("{noop}megala").
                roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(praga, thanigai, megala);
    }

    //restricting access based on roles
*/

}
