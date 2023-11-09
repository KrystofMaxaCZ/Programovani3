import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class generatorKlicu {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        //AES je druh zamku - my vygenerujeme klic pro tento zamek
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();

        byte[] k = key.getEncoded();

        Path fn = Paths.get("klic.dat");
        Files.write(fn, k);

        //String str = Base64.getEncoder().encodeToString(k);
        //System.out.println(str);
    }
}
