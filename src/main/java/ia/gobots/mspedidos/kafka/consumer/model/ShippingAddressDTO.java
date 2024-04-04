package ia.gobots.mspedidos.kafka.consumer.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddressDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String postalCode;
    private String streetName;
    private String number;
    private String additionalInfo;
    private Long requestId;
}
