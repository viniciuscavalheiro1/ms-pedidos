package ia.gobots.mspedidos.kafka;

import ia.gobots.mspedidos.domain.order.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "topic-name";

    @Autowired
    private KafkaTemplate<String, RequestDTO> kafkaTemplate;

    public boolean sendMessage(RequestDTO message) {
        kafkaTemplate.send(TOPIC, message);
        return true;
    }
}