package co.com.booker.utilities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MD5 {

    private static final String FROM = "DESede";
    private static final String SECRET_KEY = "qualityinfosolutions";

    @SneakyThrows
    public static String encrypt(String value) {
        String base64Encrypted = "";
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digestOfPassword = md.digest(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        SecretKey key = new SecretKeySpec(keyBytes, FROM);
        Cipher cipher = Cipher.getInstance(FROM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] plainTextBytes = value.getBytes(StandardCharsets.UTF_8);
        byte[] buf = cipher.doFinal(plainTextBytes);
        byte[] base64Bytes = Base64.encodeBase64(buf);
        base64Encrypted = new String(base64Bytes);
        return base64Encrypted;
    }

    @SneakyThrows
    public static String decrypt(String value) {
        String base64EncryptedString = "";
        byte[] message = Base64.decodeBase64(value.getBytes(StandardCharsets.UTF_8));
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digestOfPassword = md.digest(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        SecretKey key = new SecretKeySpec(keyBytes, FROM);
        Cipher decipher = Cipher.getInstance(FROM);
        decipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainText = decipher.doFinal(message);
        base64EncryptedString = new String(plainText, StandardCharsets.UTF_8);
        return base64EncryptedString;
    }
}