package ia.gobots.mspedidos.kafka;

import ia.gobots.mspedidos.domain.order.Request;
import ia.gobots.mspedidos.domain.order.RequestDTO;
import ia.gobots.mspedidos.services.RequestService;;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final RequestService requestService;
    private ModelMapper modelMapper;

    public KafkaConsumer(RequestService requestService, ModelMapper modelMapper) {
        this.requestService = requestService;
        this.modelMapper = modelMapper;
    }

    @KafkaListener(topics = "topic-name", groupId = "my-group")
    public void consume(RequestDTO message) {
        Request request = modelMapper.map(message, Request.class);
        requestService.createRequest(request);
    }
}