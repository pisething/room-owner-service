package com.piseth.java.school.roomownerservice.service.sercurity;

import reactor.core.publisher.Mono;

public interface CurrentOwnerService {
	Mono<String> getCurrentOwnerId();
}
