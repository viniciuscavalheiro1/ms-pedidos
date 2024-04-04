package ia.gobots.mspedidos.domain.order;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer itemId;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private String url;
    private String request;
}