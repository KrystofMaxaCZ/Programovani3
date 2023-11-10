import javax.crypto.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Desifruj {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] klicPrivateByte = Files.readAllBytes(Paths.get("klicPrivat.dat"));
        Path path = Paths.get("message.dat");
        byte[] message = Files.readAllBytes(path);
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(klicPrivateByte);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.PRIVATE_KEY, privateKey);

        String cipherText = new String(cipher.doFinal(message));
        System.out.println(cipherText);

    }
}
