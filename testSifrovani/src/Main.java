import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //pouziju file jako input pro zpravu
        File file = new File("zprava");
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(0,".");
        hashMap.put(1,",");
        hashMap.put(2,":");
        hashMap.put(3, ";");
        // mezera mezi slovy se da po dokonceni prepsani celeho slova

        Scanner sc = new Scanner(file);

        while (sc.hasNext()){
            //slovo - scanner vezme string a uloziho do stringu slovo
            String slovo = sc.next();

            for (int i = 0; i < slovo.length(); i++) {
                //vezme pismeno ze slova a prevede ho do cisla
                char ch = slovo.charAt(i);
                int cislo = ch;

                while(cislo>=1){
                    //prevod cisla do ctyrkove soustavy a vytisknuti sifry
                    int x = cislo%4;
                    cislo= cislo/4;
                    System.out.print(hashMap.get(x));
                }
            }
            System.out.print(" "); //mezera mezi slovy
        }
    }
}