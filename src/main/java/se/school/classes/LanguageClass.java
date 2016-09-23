package se.school.classes;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/7/2016.
 */
public class LanguageClass {

    private long languageId;
    private String language;

    public LanguageClass(String language) {
        this.language = language;
    }
    public LanguageClass() {}

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
