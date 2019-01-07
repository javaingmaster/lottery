package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 周廷宇
 */
@Table(name = "lottery_prize")
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prizeId;

    @Column(name = "prize_name")
    @NotNull
    private String prizeName;

    @Column(name = "prize_worth")
    private Integer prizeWorth;

    @Column(name = "prize_stock")
    @NotNull
    private Integer prizeStock;

    private List<Activity> activities;

    public Prize() {
    }

    public Prize(@NotNull String prizeName, @NotNull Integer prizeStock) {
        this.prizeName = prizeName;
        this.prizeStock = prizeStock;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Integer getPrizeWorth() {
        return prizeWorth;
    }

    public void setPrizeWorth(Integer prizeWorth) {
        this.prizeWorth = prizeWorth;
    }

    public Integer getPrizeStock() {
        return prizeStock;
    }

    public void setPrizeStock(Integer prizeStock) {
        this.prizeStock = prizeStock;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "prizeName='" + prizeName + '\'' +
                ", prizeStock=" + prizeStock +
                '}';
    }
}
