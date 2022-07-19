package co.com.claro.entity;

import jakarta.persistence.*;
import lombok.*;

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
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", equipment=" + equipment +
                ", client=" + client +
                ", vendor=" + vendor +
                '}';
    }
}
