package com.piseth.java.school.roomservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.piseth.java.school.roomservice.domain.Room;

public interface RoomRepository extends ReactiveMongoRepository<Room, String>{
	
	
	

	
}
