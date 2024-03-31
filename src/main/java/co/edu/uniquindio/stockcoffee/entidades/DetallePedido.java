package co.edu.uniquindio.stockcoffee.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetallePedido implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double precioUnitario;
    @Column(nullable = false)
    private double IVA;
    @ManyToOne
    @ToString.Exclude
    private PedidoCafe pedidoCafe;
    @ManyToOne
    @ToString.Exclude
    private CafeEmpacado cafeEmpacado;

}
