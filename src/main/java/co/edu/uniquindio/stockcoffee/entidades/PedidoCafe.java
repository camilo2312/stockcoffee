package co.edu.uniquindio.stockcoffee.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PedidoCafe implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    @Column(nullable = false)
    private LocalDate fechaVencimiento;
    @Column(nullable = false)
    private double valorTotal;
    @ManyToOne
    @ToString.Exclude
    private Administrador administrador;
    @ManyToOne
    @ToString.Exclude
    private Cliente cliente;
    @OneToMany(mappedBy = "pedidoCafe")
    private List<DetallePedido> lstDetalle;


}
