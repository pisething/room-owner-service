package com.piseth.java.school.roomservice.dto;

import java.util.List;

import com.piseth.java.school.roomservice.domain.enumeration.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomUpdateRequest {
    // All fields optional; nulls ignored by MapStruct patch

    private String name;
    private String description;

    @Positive
    private Double price;

    private String currencyCode;

    @Min(0)
    private Integer floor;

    @Positive
    private Double roomSize;

    private RoomType roomType;
    private PropertyType propertyType;

    private AddressDto address;

    private Boolean hasFan;
    private Boolean hasAirConditioner;
    private Boolean hasParking;
    private Boolean hasPrivateBathroom;
    private Boolean hasBalcony;
    private Boolean hasKitchen;
    private Boolean hasFridge;
    private Boolean hasWashingMachine;
    private Boolean hasTV;
    private Boolean hasWiFi;
    private Boolean hasElevator;

    @Positive
    private Integer maxOccupants;
    private Boolean isPetFriendly;
    private Boolean isSmokingAllowed;
    private Boolean isSharedRoom;
    private GenderPreference genderPreference;

    private Double distanceToCenter;
    private List<String> nearbyLandmarks;
    private Boolean isUtilityIncluded;
    private Boolean depositRequired;
    @Positive
    private Double depositAmount;
    @Positive
    private Integer minStayMonths;
    private String contactPhone;

    private List<String> photoUrls;
    private String videoUrl;
    private Boolean verifiedListing;

    private RoomStatus status;
}
