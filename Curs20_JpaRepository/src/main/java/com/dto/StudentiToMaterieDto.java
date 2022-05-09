package com.dto;

import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentiToMaterieDto {

    private Long studentId;
    private Long materieId;
}
