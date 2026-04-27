package AuthenticationSystem.VeriLock.controller;

import AuthenticationSystem.VeriLock.io.ProfileRequest;
import AuthenticationSystem.VeriLock.io.ProfileResponse;
import AuthenticationSystem.VeriLock.service.EmailService;
import AuthenticationSystem.VeriLock.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1.0")
public class ProfileController {
    private final ProfileService profileService;
    private final EmailService emailService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request) {
        System.out.println("🔥 REGISTER API HIT");
        ProfileResponse response = profileService.createProfile(request);
        emailService.sendWelcomeEmail(response.getEmail(), response.getName());
        return response;
    }
    @GetMapping("/profile")
    public ProfileResponse getProfile(@CurrentSecurityContext(expression = "authentication?.name") String email){
        return profileService.getProfile(email);
    }
}
