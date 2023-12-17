package mx.edu.utez.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "move")
public class MoveBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_move")
    private Integer idMove;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "poder")
    private Integer poder;

    @ManyToMany(mappedBy = "moves")
    @JsonIgnoreProperties({"moves"})
    private Set<NewPokemonBean> pokemons = new HashSet<>();
}
