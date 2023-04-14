package org.itson.utilidades;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

/**
 * Esta clase implementa la interfaz AttributeConverter y se encarga de
 * encriptar y desencriptar valores en JPA.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
@Converter
public class JPAEncryptor implements AttributeConverter<String, String> {

    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final byte[] SECRET_KEY_BYTES = "mySecretKey12345".getBytes(StandardCharsets.UTF_8);

    private final Key secretKey = new SecretKeySpec(SECRET_KEY_BYTES, "AES");

    /**
     * Método que encripta un String utilizando la clave secreta establecida y
     * el algoritmo AES/ECB/PKCS5Padding.
     *
     * @param attribute el valor a encriptar
     * @return el valor encriptado en String
     * @throws RuntimeException si ocurre un error durante el proceso de
     * encriptación
     */
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(attribute.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encriptando el campo", e);
        }
    }

    /**
     * Método que desencripta un String utilizando la clave secreta establecida
     * y el algoritmo AES/ECB/PKCS5Padding.
     *
     * @param dbData el valor a desencriptar de la base de datos
     * @return el valor desencriptado en String
     * @throws RuntimeException si ocurre un error durante el proceso de
     * desencriptación
     */
    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(dbData);
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error desencriptando el campo", e);
        }
    }
}
