package ia.gobots.mspedidos.domain.order;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "buyer")
@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Buyer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buyer_seq")
    @SequenceGenerator(name = "buyer_seq", sequenceName = "BUYER_SEQ", allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
