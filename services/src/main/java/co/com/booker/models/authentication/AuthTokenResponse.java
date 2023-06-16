package co.com.booker.models.authentication;

import lombok.Data;

@Data
public class AuthTokenResponse {
    private String token;
    private String reason;
}