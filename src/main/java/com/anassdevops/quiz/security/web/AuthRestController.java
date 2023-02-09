package com.anassdevops.quiz.security.web;

import com.anassdevops.quiz.security.SecurityUtil;
import com.anassdevops.quiz.security.dto.AppUserDto;
import com.anassdevops.quiz.security.entity.AppUser;
import com.anassdevops.quiz.security.service.AuthService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class AuthRestController {

    private AuthService authService;

    @GetMapping("/refreshToken")
    public void getRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authToken = request.getHeader(SecurityUtil.AUTH_HEAD);
        if(authToken != null && authToken.startsWith(SecurityUtil.PREFIX)) {
            try {
                String jwtToken = authToken.substring(SecurityUtil.PREFIX.length());
                Algorithm algorithm = Algorithm.HMAC256(SecurityUtil.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwtToken);
                String username = decodedJWT.getSubject();

                AppUser appUser = authService.loadUserByUsername(username);
                String accessToken = JWT.create()
                        .withSubject(username)
                        .withExpiresAt(new Date(System.currentTimeMillis()+SecurityUtil.ACCESS_TOKEN_DURATION))
                        .withIssuer(request.getRequestURI().toString())
                        .withClaim("roles", appUser.getRoles().stream().map(r->r.getName()).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> idToken = new HashMap<>();
                idToken.put("access-token", accessToken);
                idToken.put("refresh-token", jwtToken);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), idToken);
            } catch (Exception e) {
                response.setHeader("error-message", e.getMessage());
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            throw new RuntimeException("Refresh Token Required!!!!");
        }
    }

}

