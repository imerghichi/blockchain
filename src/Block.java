import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {

    private String version;
    private Date date;
    private String hash;
    private String previous_hash;
    private String data;

    public Block(String version, Date date, String data) {
        this.version = version;
        this.date = date;
        this.data = data;
        this.hash = compute_hash();
        
    }
//using SHA 265 to find hash
    public String compute_hash() {
        String stringtohsh = "" + this.version + this.date + this.previous_hash + this.data ;
        MessageDigest digest;
        String encoded = null;

        try  {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(stringtohsh.getBytes(StandardCharsets.UTF_8));
            encoded = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.hash = encoded;
        return encoded;

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevious_hash() {
        return previous_hash;
    }

    public void setPrevious_hash(String previous_hash) {
        this.previous_hash = previous_hash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
