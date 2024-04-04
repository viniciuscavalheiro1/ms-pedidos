package ia.gobots.mspedidos.kafka.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ia.gobots.mspedidos.domain.order.Request;
import ia.gobots.mspedidos.kafka.consumer.model.RequestDTO;
import ia.gobots.mspedidos.services.RequestService;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final RequestService requestService;
    private final ModelMapper modelMapper;

    public KafkaConsumerService(RequestService requestService, ModelMapper modelMapper) {
        this.requestService = requestService;
        this.modelMapper = modelMapper;
    }

    @KafkaListener(topics = "meu_topico", groupId = "group_id")
    public void listen(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RequestDTO requestDTO = objectMapper.readValue(message, RequestDTO.class);
        Request request = modelMapper.map(requestDTO, Request.class);
        requestService.createRequest(request);
        System.out.println("Pedido salvo no DB");
        System.out.println("Mensagem recebida: " + message);

    }
}