package ia.gobots.mspedidos.domain.order;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "billingaddress")
@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class BillingAddress  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billingaddress_seq")
    @SequenceGenerator(name = "billingaddress_seq", sequenceName = "BILLINGADDRESS_SEQ", allocationSize = 1)
    private Long id;
    private String postalCode;
    private String streetName;
    private String number;
    private String additionalInfo;
    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
