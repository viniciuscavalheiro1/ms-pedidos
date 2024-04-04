package ia.gobots.mspedidos.kafka.producer.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO implements Serializable {
    private String orderId;
    //private LocalDateTime createdAt;
    //private LocalDateTime updatedAt;
    private String status;
    private List<ItemDTO> items;
    private String seller;
    private BuyerDTO buyer;
    private ShippingAddressDTO shippingAddress;
    private BillingAddressDTO billingAddress;
    private PaymentDTO payment;
}
