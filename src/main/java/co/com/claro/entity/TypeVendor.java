package co.com.claro.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "type_vendor")
public class TypeVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeVendor typeVendor = (TypeVendor) o;

        return Objects.equals(id, typeVendor.id);
    }

    @Override
    public String toString() {
        return "TypeVendor{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
