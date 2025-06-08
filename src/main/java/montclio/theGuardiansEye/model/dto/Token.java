package montclio.theGuardiansEye.model.dto;

public record Token(
    String token, 
    String type,
    String email
) {}

