package mx.edu.utez.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RegionDto {
    private Integer idRegion;
    private String nombre;
}
