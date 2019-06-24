// package com.btp.security;

// import java.util.Arrays;

// import com.btp.service.BtpService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// // import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// // import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
// // import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// // import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;

// public class SecurityConfiguration<SecurityRequestHeaderAuthenticationFilter> extends WebSecurityConfigurerAdapter {

//     @Autowired
//     BtpService userService;

//     // @Override
//     // protected void configure(HttpSecurity http) throws Exception {
//     //     http.addFilterBefore(ssoFilter(), RequestHeaderAuthenticationFilter.class)
//     //     .authenticationProvider(
//     //         preauthAuthProvider())
//     //         .csrf().disable()
//     //         .authorizeRequests().anyRequest().authenticated();
//     //         http.cors().and();
//     //         http.headers().frameOptions().sameOrigin()
//     //         .httpStrictTransportSecurity().disable();
//     // }

//     // @Bean
//     // CorsConfigurationSource corsConfigurationSource() {
//     //     CorsConfiguration configuration = new CorsConfiguration();
//     //     configuration.setAllowCredentials(true);
//     //     configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//     //     configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "OPTIONS"));
//     //     configuration.setAllowedHeaders(Arrays.asList("Origin", "X-Requested-With", "Content-Type", "Content-Encoding", "x-xsrf-token"));
//     //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//     //     source.registerCorsConfiguration("/**", configuration);
//     //     return source;
//     // }

//     // @Autowired
//     // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//     //     auth.authenticationProvider(preauthAuthProvider());
//     // }

//     // @Bean
//     // public UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken> UserDetailsByNameServiceWrapper() {
//     //     UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken> wrapper =
//     //     new UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken>();
//     //     wrapper.setUserDetailsService(userService);
//     //     return wrapper;
//     // }

//     // @Bean
//     // public PreAuthenticatedAuthenticationProvider preauthAuthProvider() {
//     //     PreAuthenticatedAuthenticationProvider preauthAuthProvider = new PreAuthenticatedAuthenticationProvider();
//     //     preauthAuthProvider.setPreAuthenticatedUserDetailsService(userDetailsServiceWrapper());
//     //     return preauthAuthProvider;
//     // }

//     // @Bean
//     // public SecurityRequestHeaderAuthenticationFilter ssoFilter() throws Exception {
//     //     SecurityRequestHeaderAuthenticationFilter filter = new SecurityRequestHeaderAuthenticationFilter();
//     // }

// }