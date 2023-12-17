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
@Table(name = "newpokemon")
public class NewPokemonBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_newpokemon")
    private Integer idNewPokemon;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "eslegendario")
    private Boolean esLegendario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"pokemon"})
    private UsuarioBean usuarioBean;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"pokemon"})
    private RegionBean regionBean;

    @ManyToMany
    @JoinTable(name = "newpokemon_has_move", joinColumns = @JoinColumn(name = "newpokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "move_id"))
    private Set<MoveBean> move = new HashSet<>();
}
