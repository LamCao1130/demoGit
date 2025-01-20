package t3h.edu.vn.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t3h.edu.vn.ss.entity.AccountEntity;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer > {
    List<AccountEntity> findAll();

     public AccountEntity save(AccountEntity account);

     @Query(value = "select * from account where accountId = ?1", nativeQuery = true)
     public AccountEntity findById(int id);

//    @Query(value = "DELETE FROM `shopdb`.`account`\n" +
//            "WHERE accountId = ?1 ;", nativeQuery = true)
//    public void deleteAccountEntityById(Integer id);

    void delete(AccountEntity account);

    @Query(value = "select * from account where email  like ? ;", nativeQuery = true)
    public AccountEntity findByEmailAndRoleAdmin(String email);


}
