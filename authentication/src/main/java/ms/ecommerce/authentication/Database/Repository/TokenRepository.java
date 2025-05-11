package ms.ecommerce.authentication.Database.Repository;

import ms.ecommerce.authentication.Database.Entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
    Optional<TokenEntity> findByToken(String token);

    @Query("SELECT t FROM TokenEntity t INNER JOIN UserEntity u ON t.user.id = u.id WHERE u.id = " +
            ":userId AND (t.expired = false OR t.revoked = false)")
    List<TokenEntity> findAllValidTokenByUser(UUID userId);

}
