package ia.gobots.mspedidos.kafka.producer.controller;


import ia.gobots.mspedidos.kafka.producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
public class KafkaMessageController {

    @Autowired
    private KafkaProducerService publisher;


    @PostMapping("/publish")
    public void sendEvents(@RequestBody String string) {
        publisher.sendMessage(string);
    }

}
