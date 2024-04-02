package ia.gobots.mspedidos.config;

import ia.gobots.mspedidos.domain.order.Request;
import ia.gobots.mspedidos.domain.order.RequestDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configure o ModelMapper para mapear os relacionamentos corretamente
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Mapeamento dos relacionamentos para a classe RequestDTO
        modelMapper.createTypeMap(Request.class, RequestDTO.class)
                .addMapping(src -> src.getBuyerObject(), RequestDTO::setBuyer)
                .addMapping(src -> src.getShippingAddressObject(), RequestDTO::setShippingAddress)
                .addMapping(src -> src.getBillingAddressObject(), RequestDTO::setBillingAddress)
                .addMapping(src -> src.getPaymentObject(), RequestDTO::setPayment);

        return modelMapper;
    }
}