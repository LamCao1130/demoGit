package t3h.edu.vn.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import t3h.edu.vn.ss.dto.AccountDto;
import t3h.edu.vn.ss.entity.AccountEntity;
import t3h.edu.vn.ss.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

    public AccountEntity add(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setPhoneNumber(accountDto.getPhoneNumber());
        accountEntity.setFullname(accountDto.getFullname());
        accountEntity.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        accountEntity.setEmail(accountDto.getEmail());
        accountEntity.setGender(accountDto.getGender());
        accountEntity.setIsAdmin(accountDto.getIsAdmin());
        return accountRepository.save(accountEntity);
    }

    public void delete(AccountEntity accountEntity) {
        accountRepository.delete(accountEntity);
    }

    public AccountEntity findById(int id) {
        return accountRepository.findById(id);
    }

    public AccountEntity update(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }

    public AccountEntity findByEmail(String email) {
        return accountRepository.findByEmailAndRoleAdmin(email);
    }

}
