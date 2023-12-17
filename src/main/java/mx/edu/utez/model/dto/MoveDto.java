package mx.edu.utez.model.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MoveDto {
    private Integer idMove;
    private String nombre;
    private String tipo;
    private Integer poder;
    private List<Integer> pokemons;
}
