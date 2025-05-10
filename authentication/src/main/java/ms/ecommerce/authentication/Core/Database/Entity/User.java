package ms.ecommerce.authentication.Core.Database.Entity;


import java.util.UUID;


public record Event(

        UUID id,
        String indentifier,
        String username,
        String password,
        String role,
        boolean active
) {
}
