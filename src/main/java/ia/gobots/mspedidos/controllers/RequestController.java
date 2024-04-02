package ia.gobots.mspedidos.controllers;

import ia.gobots.mspedidos.domain.order.Request;
import ia.gobots.mspedidos.domain.order.RequestDTO;
import ia.gobots.mspedidos.services.RequestService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    private final RequestService requestService;
    private final ModelMapper modelMapper;

    public RequestController(RequestService requestService, ModelMapper modelMapper) {
        this.requestService = requestService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public ResponseEntity<List<RequestDTO>> getAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        List<RequestDTO> requestDTOs = requests.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(requestDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestDTO> getRequestById(@PathVariable Long id) {
        Request request = requestService.getRequestById(id);
        if (request != null) {
            RequestDTO requestDTO = modelMapper.map(request, RequestDTO.class);
            return ResponseEntity.ok(requestDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RequestDTO> createRequest(@RequestBody Request request) {
        Request createdRequest = requestService.createRequest(request);
        RequestDTO requestDTO = modelMapper.map(createdRequest, RequestDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(requestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestDTO> updateRequest(@PathVariable Long id, @RequestBody Request request) {
        Request updatedRequest = requestService.updateRequest(id, request);
        if (updatedRequest != null) {
            RequestDTO requestDTO = modelMapper.map(updatedRequest, RequestDTO.class);
            return ResponseEntity.ok(requestDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        boolean deleted = requestService.deleteRequest(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private RequestDTO convertToDTO(Request request) {
        return modelMapper.map(request, RequestDTO.class);
    }
}