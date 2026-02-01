package com.shuttle.youtube.hospitalManagement.dto;

import com.shuttle.youtube.hospitalManagement.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupCountResponseEntity {
    private BloodGroupType bloodGroupType;
    private Long count;
}
