package com.example.AttandanceManage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login ->
				login.loginProcessingUrl("/login").loginPage("/login")
                .failureUrl("/login?error").permitAll()
						.failureHandler(new MyAuthenticationFailureHandler())       // 認証失敗時に呼ばれるハンドラクラス
		).logout(logout -> logout
                .logoutSuccessUrl("/login")
        ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .anyRequest().authenticated()
        ).formLogin().successHandler(new MyAuthenticationSuccessHandler());
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
        UserDetails user = userBuilder.username("user").password("password")
                                    .roles("USER").build();
        UserDetails admin = userBuilder.username("admin").password("password")
                                    .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user, admin);
	}
}