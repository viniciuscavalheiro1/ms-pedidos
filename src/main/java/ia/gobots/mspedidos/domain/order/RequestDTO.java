package ia.gobots.mspedidos.domain.order;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String orderId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private List<ItemDTO> items;
    private String seller;
    private BuyerDTO buyer;
    private ShippingAddressDTO shippingAddress;
    private BillingAddressDTO billingAddress;
    private PaymentDTO payment;

    public RequestDTO(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RequestDTO requestDTO = objectMapper.readValue(jsonString, RequestDTO.class);
        this.orderId = requestDTO.orderId;
        this.createdAt = requestDTO.createdAt;
        this.updatedAt = requestDTO.updatedAt;
        this.status = requestDTO.status;
        this.items = requestDTO.items;
        this.seller = requestDTO.seller;
        this.buyer = requestDTO.buyer;
        this.shippingAddress = requestDTO.shippingAddress;
        this.billingAddress = requestDTO.billingAddress;
        this.payment = requestDTO.payment;
    }
}
