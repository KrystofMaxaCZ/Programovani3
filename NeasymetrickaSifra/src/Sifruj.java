import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Sifruj {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        String message = "Mam rad sifrovani";

        //nactu PublicKlic se souboru pro zasifrovani
        byte[] publicKeyBytes = Files.readAllBytes(Paths.get("klicPublic.dat"));
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.PUBLIC_KEY, publicKey);

        byte[] encryptedBytes = cipher.doFinal(message.getBytes());

        Path path = Paths.get("message.dat");
        Files.write(path,encryptedBytes);
    }
}
