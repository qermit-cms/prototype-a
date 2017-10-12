package cms.qermit.prototype.data;

import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class Token {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "value")
    private String value;
    @Column(name = "expiry_date")
    private long expiryDate;

    protected Token() {
    }

    public Token(final String id, final String value, final long expiryDate) {
        this.id = id;
        this.value = value;
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("value", "****")
                .add("expiryDate", expiryDate)
                .toString();
    }
}
