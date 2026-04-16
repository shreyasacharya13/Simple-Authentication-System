package AuthenticationSystem.VeriLock.service;

import AuthenticationSystem.VeriLock.io.ProfileRequest;
import AuthenticationSystem.VeriLock.io.ProfileResponse;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);
}
