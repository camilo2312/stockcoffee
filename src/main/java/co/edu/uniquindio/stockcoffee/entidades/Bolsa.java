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
public class Bolsa implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Preguntar si es de la clase origen
    private String origen;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double precioCompra;
    @ManyToOne
    @ToString.Exclude
    private Color color;
    @OneToOne(mappedBy = "bolsa")
    private Gramaje gramaje;
    @ManyToOne
    @ToString.Exclude
    private Proveedor proveedor;
    @ManyToMany(mappedBy = "lstBolsas")
    private List<CafeEmpacado> lstCafeEmpacado;
}
