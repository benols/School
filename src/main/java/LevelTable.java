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
@Table(name="LevelTable")
@NamedQueries({
        @NamedQuery(name="selectAllLevels",query="SELECT t FROM LevelTable t"),
        @NamedQuery(name="selectOneLevel",query="SELECT t FROM LevelTable t WHERE t.levelId = :id")
})
public class LevelTable implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "levelId", updatable = false, nullable = false)
    private long levelId;

    @Column(length = 50, name = "level", nullable = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String level;


    public LevelTable(String level){
        this.level = level;
    }
    public LevelTable(){
        this.level = "";
    }


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
