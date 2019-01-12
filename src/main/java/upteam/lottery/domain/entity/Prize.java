package upteam.lottery.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author 周廷宇
 */
@Table(name = "lottery_prize")
public class Prize implements Serializable {


    private static final long serialVersionUID = 1807835691482130194L;
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

    @Column(name = "prize_ratio")
    private Double prizeRatio;

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

    public Double getPrizeRatio() {
        return prizeRatio;
    }

    public void setPrizeRatio(Double prizeRatio) {
        this.prizeRatio = prizeRatio;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "prizeName='" + prizeName + '\'' +
                ", prizeStock=" + prizeStock +
                '}';
    }
}
