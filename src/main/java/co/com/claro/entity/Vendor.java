package co.com.claro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty
    @Column(nullable = false)
    private String name;
    @NotEmpty
    @Column(nullable = false)
    private String dni;

    @NotEmpty
    @Column(nullable = false)
    private String code;

    private String city;

    @NotNull
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
