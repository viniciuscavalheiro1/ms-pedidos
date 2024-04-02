package ia.gobots.mspedidos.kafka.resources;


import ia.gobots.mspedidos.domain.order.RequestDTO;
import ia.gobots.mspedidos.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class KafkaProducerController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody RequestDTO message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body("Message sent successfully");
    }
}
