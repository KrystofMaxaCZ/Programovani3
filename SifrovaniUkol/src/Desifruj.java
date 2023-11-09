import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Desifruj {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] k = Files.readAllBytes(Paths.get("klic.dat"));
        SecretKey key = new SecretKeySpec(k, "AES");

        Path path = Paths.get("message.dat");
        byte[] message = Files.readAllBytes(path);
//        byte[] message = Files.readAllBytes(Paths.get("message.dat"));
//        String str = Arrays.toString(message);

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(message));
        System.out.println(new String(cipherText));
//        byte[] out = cipher.doFinal(message.getBytes());
//        System.out.println(message);


//        System.out.println(out);
    }
}
