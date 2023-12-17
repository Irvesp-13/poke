package mx.edu.utez.model.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewPokemonDto {
    private Integer idNewPokemon;
    private String nombre;
    private String tipo;
    private Integer nivel;
    private Boolean esLegendario;
    private Integer usuario_idusuario;
    private Integer region_idregion;
    private List<Integer> moves;
}
