package ia.gobots.mspedidos.kafka.producer.controller;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ia.gobots.mspedidos.kafka.producer.service.KafkaProducerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class KafkaMessageControllerTest {

    private MockMvc mockMvc;

    @Mock
    private KafkaProducerService kafkaProducerService;

    @InjectMocks
    private KafkaMessageController kafkaMessageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(kafkaMessageController).build();
    }

    @Test
    void testSendEvents() throws Exception {
        String message = "Test message";

        mockMvc.perform(post("/api/producer/publish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(message))
                .andExpect(status().isOk());

        verify(kafkaProducerService, times(1)).sendMessage(message);
    }
}
