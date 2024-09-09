package com.napas.demo_qrcode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class RsaKeyConfig {
    @Bean
    public RSAPublicKey rsaPublicKey() {
        try {
            // Chuỗi PEM của khóa công khai
            String publicKeyPEM = "-----BEGIN PUBLIC KEY-----\n" +
                    "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAmSAYM+mf3V9RWzOESHdItS6c0exUG1lYOFyJ5lnFa1EW6j2M/tN+GJOlIPeUZgTBvH1edwsYijt7bbPNDqEiMEhoSIoDNISkiEmkICK45vp+T/pqRA4FEtJ9g2Gd/xnyI8zFZ64gkv3d3vGOcJ3/mAAVU/TH0vIZptRx6ERMNDY9BWkSp9EeZIcjDwivRYYF0ckOd1khVeen3TSwPsDjsNW2HS8PZWf0ieusZxmqMk6pg4Zsb+mis7VOwpvMvFIuRPrBT6AmlkGmM7fEfKFUxSAg8aPr8S/YgsSkkxrFc/82e/CnFjP1iI2AidFCM4xT/QffCXwHTicF0UgwjSDXLkGB3AIzfnqd6IdhsFL9ip6Urr0KBd6YV4DsK8VYp44hFAWy1hHO2nOyWtBnet7XSKjKl/ElUXZQUCrnVDAhGr5P/2gkanN2GwMP3+ROjGPevkMCOSqqBE/40dnMqHKsEzvVUcO2igZbTh/ZPJ2XbPfJfiVrxK84pnC2EB+Or4FE25M5eAlkqWf8lb98zoS3rHyjq1GY/JLB10GZKxesnSM5mFVA60SchetKkzMDeLughVszxZWHOHIDj9FgOuZ8Yob4Rk61aI+7L4MMtMHSkZJEiH4bPOZNfCzdBTJjoX1PmXsNS0qni7IDmhr60FNjFo0q8OubWdZeC/63ZNZjhVECAwEAAQ==\n" +
                    "-----END PUBLIC KEY-----";

            // Loại bỏ đầu và cuối của chuỗi PEM
            publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----", "")
                    .replace("-----END PUBLIC KEY-----", "")
                    .replaceAll("\\s+", "");

            // Giải mã chuỗi base64 thành byte[]
            byte[] decoded = Base64.getDecoder().decode(publicKeyPEM);

            // Tạo đối tượng PublicKeySpec
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Bean
    public RSAPrivateKey rsaPrivateKey() {
        try {
            String privateKeyPEM = "-----BEGIN RSA PRIVATE KEY-----\n" +
                    "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\n" +
                    "-----END RSA PRIVATE KEY-----";

            // Loại bỏ header và footer của PEM
            privateKeyPEM = privateKeyPEM.replace("-----BEGIN RSA PRIVATE KEY-----", "")
                    .replace("-----END RSA PRIVATE KEY-----", "")
                    .replaceAll("\\s+", "");

            byte[] decoded = Base64.getDecoder().decode(privateKeyPEM);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec  keySpec = new PKCS8EncodedKeySpec(decoded);
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
