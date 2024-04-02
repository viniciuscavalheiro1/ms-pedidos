package ia.gobots.mspedidos.repositories;

import ia.gobots.mspedidos.domain.order.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}