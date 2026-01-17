package com.piseth.java.school.roomownerservice.service.access;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.piseth.java.school.roomownerservice.domain.Room;

@Component
public class RoomAccessService {

    public void assertOwner(final Room room, final String ownerId) {
        if (!Objects.equals(room.getOwnerId(), ownerId)) {
            throw new IllegalStateException("You do not own this room");
        }
    }
}
