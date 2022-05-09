package com.dto;

import com.domain.Adresa;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private String nume;
    private String prenume;
    private String cnp;
    private Adresa adresa;
}
