import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Sifruj {
    public static void main(String[] args) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, IOException {
        String vstp = "Ahoj";
        //klic ze soubrou
        byte[] k = Files.readAllBytes(Paths.get("klic.dat"));
        SecretKey key = new SecretKeySpec(k, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] out = cipher.doFinal(vstp.getBytes());

        Path path = Paths.get("message.dat");
        Files.write(path,out);

        //System.out.println(Arrays.toString(out));
    }
}
