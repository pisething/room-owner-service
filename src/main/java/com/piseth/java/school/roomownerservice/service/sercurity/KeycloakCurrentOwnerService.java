package com.piseth.java.school.roomownerservice.service.sercurity;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

//@Service
public class KeycloakCurrentOwnerService implements CurrentOwnerService {

    @Override
    public Mono<String> getCurrentOwnerId() {
    	/*
        return ReactiveSecurityContextHolder.getContext()
                .map(ctx -> ctx.getAuthentication())
                .cast(JwtAuthenticationToken.class)
                .map(JwtAuthenticationToken::getToken)
                .map(jwt -> jwt.getSubject()); // same as jwt.getClaimAsString("sub")
           */
    	return Mono.just("dummy-owner-1");
    }
}
