package co.com.booker.models.authentication;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthTokenRequest {
    private String username;
    private String password;
}