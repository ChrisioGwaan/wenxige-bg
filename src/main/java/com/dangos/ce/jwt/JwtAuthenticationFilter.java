package com.dangos.ce.jwt;

import com.dangos.ce.util.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @Nonnull HttpServletRequest request,
            @Nonnull HttpServletResponse response,
            @Nonnull FilterChain filterChain
    ) throws IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            try {
                filterChain.doFilter(request, response);
            } catch (Exception e) {
                logger.error("An error occurred while processing the request", e);
                R<?> responseEntity = R.failed("An error occurred while processing the request");
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.setContentType("application/json");
                response.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity));
            }
            return; // Instantly return if no Authorization header, or it doesn't start with "Bearer "
        }
        jwt = authHeader.substring(7);
        // Catch error when extracting username from JWT
        try {
            username = jwtService.extractUsername(jwt);
        } catch (Exception e) {
            R<?> responseEntity = R.failed("Token has expired or is invalid");
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity));
            return;
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                // Custom response for invalid token
                R<?> responseEntity = R.failed("Token has expired or is invalid");
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                response.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity));
                return; // Instantly return if token is invalid
            }
        }

        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            logger.error("An error occurred while processing the request", e);
            R<?> responseEntity = R.failed("An error occurred while processing the request");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity));
        }
    }
}
