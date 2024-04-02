package ia.gobots.mspedidos.domain.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "itens")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Itens  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itens_seq")
    @SequenceGenerator(name = "itens_seq", sequenceName = "ITENS_SEQ", allocationSize = 1)
    private Long id;
    private Long itemId;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private String url;
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
