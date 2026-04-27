package AuthenticationSystem.VeriLock.io;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProfileRequest {
    @NotBlank(message = "Name should not be empty")
    private String name;
    @Email(message = "Enter  valid email address")
    @NotNull(message = "Email should not be empty")
    private String email;
    @Size(min = 6,message = "Password must be atleast 6 characters")
    private String password;
}
