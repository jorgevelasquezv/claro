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
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Equipment equipment;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @ManyToOne
    private Vendor vendor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        return Objects.equals(id, sale.id);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", equipment=" + equipment +
                ", client=" + client +
                ", vendor=" + vendor +
                '}';
    }
}
