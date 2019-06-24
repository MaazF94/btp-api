// package com.btp.security;

// import javax.servlet.http.HttpServletRequest;

// public class SecurityRequestHeaderAuthenticationFilter extends TestRequestHeaderAuthenticationFilter {

//     private boolean allowPreAuthenticatedPrincipals = true;

//     public SecurityRequestHeaderAuthenticationFilter() {
//         super();
//         this.setPrincipalRequestHeader("btpid");
//     }
    
//     @Override
//     protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
//         String username = (String) (super.getPreAuthenticatedPrincipal(request));
//         if (username == null || username.trim().equals("")) {
//             return username;
//         }
//         return username;
//     }

//     public boolean isAllowPreAuthenticatedPrincipals() {
//         return allowPreAuthenticatedPrincipals;
//     }

// }