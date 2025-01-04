package t3h.edu.vn.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t3h.edu.vn.ss.Entity.AccountEntity;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer > {
    List<AccountEntity> findAll();
}
