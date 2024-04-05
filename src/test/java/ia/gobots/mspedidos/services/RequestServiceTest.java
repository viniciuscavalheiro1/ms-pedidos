package ia.gobots.mspedidos.services;
import ia.gobots.mspedidos.domain.order.Request;
import ia.gobots.mspedidos.repositories.RequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RequestServiceTest {

    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private RequestService requestService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllRequests() {

        List<Request> requests = new ArrayList<>();
        when(requestRepository.findAll()).thenReturn(requests);

        List<Request> result = requestService.getAllRequests();

        assertEquals(requests, result);
    }

    @Test
    void testGetRequestById() {

        Long id = 1L;
        Request request = new Request();
        when(requestRepository.findById(id)).thenReturn(Optional.of(request));

        Request result = requestService.getRequestById(id);

        assertEquals(request, result);
    }


    @Test
    void testUpdateRequest() {
        Long id = 1L;
        Request request = new Request();
        when(requestRepository.existsById(id)).thenReturn(true);
        when(requestRepository.save(request)).thenReturn(request);

        Request result = requestService.updateRequest(id, request);

        assertEquals(request, result);
    }

    @Test
    void testUpdateRequestWhenNotFound() {
        Long id = 1L;
        Request request = new Request();
        when(requestRepository.existsById(id)).thenReturn(false);

        Request result = requestService.updateRequest(id, request);

        assertNull(result);
    }

    @Test
    void testDeleteRequest() {

        Long id = 1L;
        when(requestRepository.existsById(id)).thenReturn(true);

        boolean result = requestService.deleteRequest(id);

        assertTrue(result);
        verify(requestRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteRequestWhenNotFound() {
        Long id = 1L;
        when(requestRepository.existsById(id)).thenReturn(false);

        boolean result = requestService.deleteRequest(id);

        assertFalse(result);
        verify(requestRepository, never()).deleteById(id);
    }
}
