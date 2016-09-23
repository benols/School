package se.school.classes;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/7/2016.
 */
public class LevelClass {

    private long levelId;
    private String level;

    public LevelClass(String level){
        this.level = level;
    }
    public LevelClass(){}

    public long getLevelId() {
        return levelId;
    }

    public void setLevelId(long levelId) {
        this.levelId = levelId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
