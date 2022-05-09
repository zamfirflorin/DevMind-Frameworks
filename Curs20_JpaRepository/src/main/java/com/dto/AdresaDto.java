package com.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdresaDto {

    private String strada;
    private String numar;
    private String localitate;
}
