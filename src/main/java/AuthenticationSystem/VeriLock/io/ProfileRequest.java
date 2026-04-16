package AuthenticationSystem.VeriLock.io;

import lombok.Data;

@Data
public class ProfileRequest {
    private String name;
    private String email;
    private String password;
}
