package mx.edu.utez.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewPokemonDto {
    private Integer idNewPokemon;
    private String nombre;
    private String tipo;
    private String nivel;
    private Integer usuario_idusuario;
    private Integer region_idregion;
}
