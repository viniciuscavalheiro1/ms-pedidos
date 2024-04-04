package ia.gobots.mspedidos.domain.order;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BillingAddressDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String postalCode;
    private String streetName;
    private String number;
    private String additionalInfo;
    private Long requestId;
}