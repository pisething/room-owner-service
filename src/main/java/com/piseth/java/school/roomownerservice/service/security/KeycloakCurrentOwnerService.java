package com.piseth.java.school.roomownerservice.service.security;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

//@Service
public class KeycloakCurrentOwnerService implements CurrentOwnerService{

	@Override
	public Mono<String> getCurrentOwnerId() {
		// TODO Auto-generated method stub
		return null;
	}

}
