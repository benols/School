/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/7/2016.
 */
public class LanguageClass {

    private long languageId;
    private String name;

    public LanguageClass(String language) {
        this.name = language;
    }
    public LanguageClass() {}

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return name;
    }

    public void setLanguage(String language) {
        this.name = language;
    }
}
