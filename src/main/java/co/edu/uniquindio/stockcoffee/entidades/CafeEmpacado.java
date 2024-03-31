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
public class CafeEmpacado implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private double precioVenta;
    @Column(nullable = false)
    private int cantidadInventario;
    @ManyToMany(mappedBy = "lstCafeEmpacado")
    private List<Bolsa> lstBolsas;
    @ManyToMany(mappedBy = "lstCafeEmpacado")
    private List<CafeTostado> lstCafeTostado;
    @OneToMany(mappedBy = "cafeEmpacado")
    private List<DetallePedido> lstDetalle;
}
