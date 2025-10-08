package com.piseth.java.school.roomservice.service;

import com.piseth.java.school.roomservice.dto.RoomCreateRequest;
import com.piseth.java.school.roomservice.dto.RoomResponse;
import com.piseth.java.school.roomservice.dto.RoomUpdateRequest;
import reactor.core.publisher.Mono;

public interface RoomService {
	
  Mono<RoomResponse> create(RoomCreateRequest request);
  Mono<RoomResponse> update(String id, RoomUpdateRequest request);
  Mono<Void> delete(String id);
	
}
