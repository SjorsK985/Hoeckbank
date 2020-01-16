package hoeckbankgroup.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Postcode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int adresID;
    private String postcode;
    private int minHuisnr;
    private int maxHuisnr;
    private String straat;
    private String stad;

    public Postcode(){
        super();
    }

    public Postcode(String postcode, int minHuisnr, int maxHuisnr, String straat, String stad) {
        this.postcode = postcode;
        this.minHuisnr = minHuisnr;
        this.maxHuisnr = maxHuisnr;
        this.straat = straat;
        this.stad = stad;
    }

    public int getAdresID() {
        return adresID;
    }

    public void setAdresID(int adresID) {
        this.adresID = adresID;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getMinHuisnr() {
        return minHuisnr;
    }

    public void setMinHuisnr(int minHuisnr) {
        this.minHuisnr = minHuisnr;
    }

    public int getMaxHuisnr() {
        return maxHuisnr;
    }

    public void setMaxHuisnr(int maxHuisnr) {
        this.maxHuisnr = maxHuisnr;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }
}
