package ia.gobots.mspedidos.kafka.consumer.model;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO implements Serializable {
    private String orderId;
    private String status;
    private List<ItemDTO> items;
    private String seller;
    private BuyerDTO buyerObject;
    private ShippingAddressDTO shippingAddressObject;
    private BillingAddressDTO billingAddressObject;
    private PaymentDTO paymentObject;
}
