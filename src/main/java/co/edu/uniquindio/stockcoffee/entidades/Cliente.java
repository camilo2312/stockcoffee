package co.edu.uniquindio.stockcoffee.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 20)
    private String numeroTelefono;
    @Column(length = 100, nullable = false)
    private String correo;
    @Column(length = 100)
    private String direccion;
    @OneToMany(mappedBy = "cliente")
    private List<PedidoCafe> lstPedidoCafe;
}
