package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

//AÑADIR A SQL

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*Metodo para configuración de seguridad sobre los metodos de la app
    * asignar permisos o restricciones según usuario, metodo
    * */

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        //primeras pruebas: gets permitidos para todos
        //admin solo borrar y update por ejemplo
        http.cors().and().csrf().disable(); //desactivar cross-cheking

        http.authorizeRequests()
                .antMatchers("/players/findAll").permitAll()
                .antMatchers("/players/findOne/{id}").permitAll()
                .antMatchers("/players/getTiradas/{idJugador}").permitAll()
                .antMatchers("/players/add").hasRole("ADMIN")
                .antMatchers("/players/delete/{id}").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    /*Metodo que nos permite crear usuarios con diferentes roles para el control de la aplicación
    * */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("user").password(passwordEncoder().encode("1234user")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("1234admin")).roles("USER", "ADMIN");

    }



    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();


    }


//    @Bean
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//
//
//
//
//    }

    //VALIDAR/PERMITIR CARACTERES ESPECIALES AL INTRODUCIR URLS

    //anotaicon bean para que sobreescriba  el httpFirewall por defecto,
    @Bean
    public HttpFirewall looseHttpFirewall(){

        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowBackSlash(true);

        return firewall;

    }
}
