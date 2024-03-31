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
public class CafeVerde implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String variedad;
    @Column(length = 200, nullable = false)
    private String proceso;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double  precioCompra;
    @Column(length = 100, nullable = false)
    private String sede;
    @ManyToOne
    @ToString.Exclude
    private Origen origen;
    @ManyToMany(mappedBy = "lstCafeVerdeAdministrador")
    private List<Administrador> lstAdministrador;
    @ManyToMany(mappedBy = "lstCafeVerdeProveedor")
    private List<Proveedor> lstProveedor;
    @OneToMany(mappedBy = "cafeVerde")
    private List<CafeTostado> lstCafeTostado;
}
