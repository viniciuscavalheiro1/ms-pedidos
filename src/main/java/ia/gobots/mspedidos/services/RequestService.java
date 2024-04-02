package ia.gobots.mspedidos.services;

import ia.gobots.mspedidos.domain.order.Request;
import ia.gobots.mspedidos.repositories.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request getRequestById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    public Request createRequest(Request request) {
        request.BillingAddressObject.setRequest(request);
        return requestRepository.save(request);
    }

    public Request updateRequest(Long id, Request request) {
        if (requestRepository.existsById(id)) {
            request.setId(id);
            return requestRepository.save(request);
        }
        return null;
    }

    public boolean deleteRequest(Long id) {
        if (requestRepository.existsById(id)) {
            requestRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
