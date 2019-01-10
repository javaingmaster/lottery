package upteam.lottery.domain.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 周廷宇
 */
public class Record implements Serializable {

    private static final long serialVersionUID = 1061168385041748060L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer record_id;

    @Column(name = "record_type")
    @NotNull
    private Integer recordType;

    @Column(name = "lucky_dog_id")
    @NotNull
    private Integer luckyDogId;

    @Column(name = "lucky_time")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date luckyTime;

    @Column(name = "prize_id")
    @NotNull
    private Integer prizeId;

    @Column(name = "activity_id")
    @NotNull
    private Integer activityId;

    public Record() {
    }

    public Record(@NotNull Integer recordType, @NotNull Integer luckyDogId, @NotNull Date luckyTime, @NotNull Integer prizeId, @NotNull Integer activityId) {
        this.recordType = recordType;
        this.luckyDogId = luckyDogId;
        this.luckyTime = luckyTime;
        this.prizeId = prizeId;
        this.activityId = activityId;
    }

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getLuckyDogId() {
        return luckyDogId;
    }

    public void setLuckyDogId(Integer luckyDogId) {
        this.luckyDogId = luckyDogId;
    }

    public Date getLuckyTime() {
        return luckyTime;
    }

    public void setLuckyTime(Date luckyTime) {
        this.luckyTime = luckyTime;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    @Override
    public String toString() {
        return "Record{" +
                "record_id=" + record_id +
                ", recordType=" + recordType +
                ", luckyDogId=" + luckyDogId +
                ", luckyTime=" + luckyTime +
                ", prizeId=" + prizeId +
                ", activityId=" + activityId +
                '}';
    }
}
