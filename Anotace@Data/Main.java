import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        ArrayList<String> jmena = new ArrayList<>();
//        jmena.add("Pavel");
//        jmena.add("Petr");
//        jmena.add("Krys");
//        jmena.add("Jan");
//        jmena.add("Honza");
//
//        jmena.add("John");
//        jmena.add("Karel");
//        jmena.add("Nik");
//        jmena.add("Sona");
//        jmena.add("Kopl");

        Scanner sc = new Scanner(System.in);
        ArrayList<Clovek> lidi = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String jmeno = sc.next();
            String prijmeni = sc.next();
            int vek = sc.nextInt();


            Clovek c = new Clovek(jmeno,prijmeni,vek);
            if(lidi.contains(c)){
                System.out.println("tento clovek jiz existuje");
                i = i-1;
            }else{
                lidi.add(c);
            }

        }
        for (int i = 0; i < lidi.size() ; i++) {
            System.out.println(lidi.get(i));
        }
    }
}