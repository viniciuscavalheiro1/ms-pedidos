package ia.gobots.mspedidos.controllers;

import ia.gobots.mspedidos.controllers.RequestController;
import ia.gobots.mspedidos.domain.order.Request;
import ia.gobots.mspedidos.domain.order.RequestDTO;
import ia.gobots.mspedidos.services.RequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RequestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RequestService requestService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private RequestController requestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(requestController).build();
    }

    @Test
    void testGetAllRequests() throws Exception {
        Request request1 = new Request();
        Request request2 = new Request();
        List<Request> requests = Arrays.asList(request1, request2);
        when(requestService.getAllRequests()).thenReturn(requests);

        mockMvc.perform(get("/api/requests/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(requests.size()));
    }

    @Test
    void testGetRequestById() throws Exception {

        long id = 1L;
        Request request = new Request();
        when(requestService.getRequestById(id)).thenReturn(request);


        mockMvc.perform(get("/api/requests/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



    @Test
    void testDeleteRequest() throws Exception {
        long id = 1L;
        when(requestService.deleteRequest(id)).thenReturn(true);

        mockMvc.perform(delete("/api/requests/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
