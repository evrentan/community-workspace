package evrentan.community.usermanager.repository;

import evrentan.community.usermanager.entity.ApplicationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUserEntity, UUID> {
}
