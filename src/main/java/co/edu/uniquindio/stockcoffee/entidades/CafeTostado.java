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
public class CafeTostado implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private String curvaTostion;
    @ManyToOne
    @ToString.Exclude
    private CafeVerde cafeVerde;
    @ManyToMany(mappedBy = "lstCafeTostado")
    private List<CafeEmpacado> lstCafeEmpacado;
}
