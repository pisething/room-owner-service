package com.piseth.java.school.roomservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.piseth.java.school.roomservice.dto.*;
import com.piseth.java.school.roomservice.service.RoomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RoomResponse> create(@Valid @RequestBody final RoomCreateRequest req) {
        return roomService.create(req);
    }

    @PatchMapping("/{id}")
    public Mono<RoomResponse> update(@PathVariable final String id,
                                     @Valid @RequestBody final RoomUpdateRequest req) {
        return roomService.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable final String id) {
        return roomService.delete(id);
    }
}
