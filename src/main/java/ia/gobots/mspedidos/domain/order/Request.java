package ia.gobots.mspedidos.domain.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "request")
@Entity(name = "Request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Request  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_seq")
    @SequenceGenerator(name = "request_seq", sequenceName = "REQUEST_SEQ", allocationSize = 1)
    private Long id;

    private String orderId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    private List<Itens> items;
    private String seller;
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    public Buyer BuyerObject;
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    public ShippingAddress ShippingAddressObject;
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    public BillingAddress BillingAddressObject;
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    public Payment PaymentObject;
}
