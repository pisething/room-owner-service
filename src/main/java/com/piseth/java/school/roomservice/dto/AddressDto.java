package com.piseth.java.school.roomservice.dto;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
    private String provinceCode;
    private String districtCode;
    private String communeCode;
    private String villageCode;

    private String provinceName;
    private String districtName;
    private String communeName;
    private String villageName;

    private String line1;
    private String line2;
    private String postalCode;

    private List<String> nearbyLandmarks;
    private GeoLocationDto geo;
}
