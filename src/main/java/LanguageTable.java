import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/7/2016.
 */

@Entity
@Table(name="LanguageTable")
@NamedQueries({
        @NamedQuery(name="selectAllLanguages",query="SELECT t FROM LanguageTable t"),
        @NamedQuery(name="selectOneLanguage",query="SELECT t FROM LanguageTable t WHERE t.languageId = :id")
})
public class LanguageTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "languageId", updatable = false, nullable = false)
    private long languageId;

    @Column(length = 30, name = "language", nullable = false)
    @NotNull
    @Size(min = 2, max = 30)
    private String language;

    public LanguageTable(String language) {
        this.language = language;
    }
    public LanguageTable() {}

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
