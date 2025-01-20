package t3h.edu.vn.ss.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountDto {

    private int accountId;
    @NotEmpty(message = "họ và tên không được phép trống")
    private String fullname;

    @Email(message = "không đúng form của email")
    @NotEmpty(message = "email không được phép trống")
    private String email;

    @Size(min =8, message = "mật khẩu phải có ít nhất 8 kí tự")
    private String password;


    private String repassword;

    @Size(min=10, max = 10, message = "số diện thoại phải có đúng 10 số")
    private String phoneNumber;


    private int gender;

    private boolean isAdmin;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public @NotEmpty(message = "họ và tên không được phép trống") String getFullname() {
        return fullname;
    }

    public void setFullname(@NotEmpty(message = "họ và tên không được phép trống") String fullname) {
        this.fullname = fullname;
    }

    public @Email(message = "không đúng form của email") @NotEmpty(message = "email không được phép trống") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "không đúng form của email") @NotEmpty(message = "email không được phép trống") String email) {
        this.email = email;
    }

    public @Size(min = 8, message = "mật khẩu phải có ít nhất 8 kí tự") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 8, message = "mật khẩu phải có ít nhất 8 kí tự") String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public @Size(min = 10, max = 10, message = "số diện thoại phải có đúng 10 số") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Size(min = 10, max = 10, message = "số diện thoại phải có đúng 10 số") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }
}
