package mx.edu.utez.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsuarioDto {
    private Integer idUsuario;
    private String nombre;
}
