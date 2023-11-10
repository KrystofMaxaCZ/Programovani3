import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.util.Base64;


public class GeneratorKlicu {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        //AES je druh zamku - my vygenerujeme klic pro tento zamek
        //RSA je pro asymetricky sifrovani
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        //vygeneovani public Klice
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("public:");System.out.println(publicKey);
        byte[] puKeyBytes =  publicKey.getEncoded();    //zapsani klice do bytu

        //vygenerovani private klice
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("private");System.out.println(privateKey);
        byte[] prKeyBytes =  privateKey.getEncoded();   //zapsani klice do bytu

        //cesta do souboru
        Path pu = Paths.get("klicPublic.dat");
        byte[] buf = privateKey.getEncoded();
        Path pr = Paths.get("klicPrivat.dat");

        //zapsani klicu do souboru
        Files.write(pu,puKeyBytes);
        Files.write(pr,prKeyBytes);

        String encodedString = Base64.getEncoder().encodeToString(buf);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);




    }
}
