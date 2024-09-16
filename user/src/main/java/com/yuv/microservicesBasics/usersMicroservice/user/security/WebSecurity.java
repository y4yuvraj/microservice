	package com.yuv.microservicesBasics.usersMicroservice.user.security;
	
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.http.HttpMethod;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
    import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
    import org.springframework.security.config.http.SessionCreationPolicy;
	import org.springframework.security.web.SecurityFilterChain;
	import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
	
	@Configuration
	@EnableWebSecurity
	public class WebSecurity {
	
		@Bean
		protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
			
			http.csrf(AbstractHttpConfigurer::disable);

			http.authorizeHttpRequests(request->request
					.requestMatchers(HttpMethod.POST,"/users").permitAll()
					.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
					.requestMatchers(HttpMethod.GET,"/uv").permitAll()
					.requestMatchers(HttpMethod.GET,"/users/**").permitAll());
			http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			http.headers(headers->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

			return http.build();
	
		}
	
	}
