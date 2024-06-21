public class Clovek {
    String jmeno;
    String prijmeni;
    int vek;

    public Clovek(String jmeno, String prijmeni, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
    }
//Lombok - anotace, muzu udelat to ze proste vymazu vse dam @data a pak bum jen final private String jmeno,
    //je tam i ze not null atak crazy
    //anotace builder
    @Override
    public String toString() {
        return jmeno + "_" + prijmeni + "_" + vek;
    }
    public  boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clovek clovek = (Clovek) o;
        return vek == clovek.vek
                && jmeno.equals(clovek.jmeno)
                && prijmeni.equals(clovek.prijmeni);
    }
}
