package org.bel.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth

                    .requestMatchers("/",
                                     "/swagger/**",
                                     "/v3/api-docs/**",
                                     "/swagger-ui/**")
                    .permitAll() // Allow these routes without authentication
//                                           .requestMatchers("/api/auth/**").permitAll()
                    .requestMatchers("/auth/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey originalKey = new SecretKeySpec(
                "20950089e72a55cf683d71f6f33bb80ad1d31fe7b7da9b4aaba99300a8ee88aca813e9f6be436f351017e591926513efd38266fcffd9443c151884b5204b84a1869d79f5e24f5b42a796f7d78e373000998d885fe510ba597f5a2209acc8af9d7f42afaacd78607fa0990e28e4933492b4473f261ba762e86b45fd21cb85bfb50f05b00e03c1f90822669037139d807c592d9382391de94f9a12e11a9f3b36f4fe94057024aeb0a0927384dc414701bcbc1a7ef29c437a2ab3acd26d40cddecdddbbd906dc2753299dc0672ec72f8182d1a7369c016c888c82125de0c260b8f9cbd657352ff41eb73a021c36545a176d4921964e8b8440cd1413833c5d517dd0".getBytes(),
                "HmacSHA256");

        return NimbusJwtDecoder.withSecretKey(originalKey).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}