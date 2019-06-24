// package com.btp.security;

// import javax.servlet.http.HttpServletRequest;

// import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
// import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
// import org.springframework.util.Assert;

// public class TestRequestHeaderAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {
//     private String principalRequestHeader = "btpid";
//     private String credentialsRequestHeader;
//     private boolean exceptionIfHeaderMissing = true;

//     private String testEmail = "maazfitter@gmail.com";

//     protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
//         String principal = request.getHeader(principalRequestHeader);
//         StringBuffer requestURL = request.getRequestURL();
//         if ((requestURL.toString().contains("localhost") || requestURL.toString().contains("10.22.19.144"))
//                 && principal == null) {
//             principal = this.testEmail;
//         } else {
//             if (principal == null && exceptionIfHeaderMissing) {
//                 throw new PreAuthenticatedCredentialsNotFoundException(
//                         principalRequestHeader + " header not found in request");
//             }
//         }
//         return principal;
//     }

//     @Override
//     protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
//         if (credentialsRequestHeader != null) {
//             return request.getHeader(credentialsRequestHeader);
//         }
//         return "N/A";
//     }

//     public void setPrincipalRequestHeader(String principalRequestHeader) {
//         Assert.hasText(principalRequestHeader, "principalRequestHeader must not be empty or null");
//         this.principalRequestHeader = credentialsRequestHeader;
//     }

//     public void setCredentialsRequestHeader(String credentialsRequestHeader) {
//         Assert.hasText(credentialsRequestHeader, "credentialsRequestHeader must not be empty or null");
//         this.credentialsRequestHeader = credentialsRequestHeader;
//     }

//     public void setExceptionIfHeaderMissing(boolean exceptionIfHeaderMissing) {
//         this.exceptionIfHeaderMissing = exceptionIfHeaderMissing;
//     }
// }