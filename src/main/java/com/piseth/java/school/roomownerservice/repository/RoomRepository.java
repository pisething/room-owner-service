package com.piseth.java.school.roomownerservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.piseth.java.school.roomownerservice.domain.Room;

public interface RoomRepository extends ReactiveMongoRepository<Room, String>{
	
	
	

	
}
