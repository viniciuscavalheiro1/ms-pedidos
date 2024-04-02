package ia.gobots.mspedidos.domain.order;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "shippingaddress")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ShippingAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shippingaddress_seq")
    @SequenceGenerator(name = "shippingaddress_seq", sequenceName = "SHIPPINGADDRESS_SEQ", allocationSize = 1)
    private Long id;
    private String postalCode;
    private String streetName;
    private String number;
    private String additionalInfo;
    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
