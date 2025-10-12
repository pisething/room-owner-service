package com.piseth.java.school.roomservice.service.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.piseth.java.school.roomownerservice.domain.Room;
import com.piseth.java.school.roomownerservice.dto.RoomDTO;
import com.piseth.java.school.roomownerservice.mapper.RoomMapper;
import com.piseth.java.school.roomownerservice.repository.RoomCustomRepository;
import com.piseth.java.school.roomownerservice.repository.RoomRepository;
import com.piseth.java.school.roomownerservice.service.impl.RoomServiceImpl;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class RoomServiceImplTest {
	/*
	@Mock
	private RoomRepository roomRepository;
	
	@Mock
	private RoomMapper roomMapper;
	
	@Mock
	private RoomCustomRepository roomCustomRepository;
	
	@InjectMocks
	private RoomServiceImpl roomService;
	
	@Test
	void createRoom_success() {
		// given
		RoomDTO roomDTO = new RoomDTO();
		roomDTO.setName("Luxury");
		
		Room room = new Room();
		room.setName("Luxury");
		
		// when
		
		when(roomRepository.save(room)).thenReturn(Mono.just(room));
		when(roomMapper.toRoom(roomDTO)).thenReturn(room);
		
		when(roomMapper.toRoomDTO(room)).thenReturn(roomDTO);
		
		//verify(roomMapper.toRoomDTO(room), times(1));
		
		// then
		
		StepVerifier.create(roomService.createRoom(roomDTO))
			.expectNext(roomDTO)
			.verifyComplete();
		
		
	}
*/
}
