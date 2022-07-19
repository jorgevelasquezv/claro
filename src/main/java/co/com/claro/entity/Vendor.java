package co.com.claro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String code;

    private String city;

    @OneToOne
    private TypeVendor typeVendor;

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", code='" + code + '\'' +
                ", city='" + city + '\'' +
                ", typeVendor='" + typeVendor.getType() + '\'' +
                '}';
    }
}
