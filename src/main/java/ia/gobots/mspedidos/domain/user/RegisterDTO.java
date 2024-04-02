package ia.gobots.mspedidos.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
