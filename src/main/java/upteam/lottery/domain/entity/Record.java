package upteam.lottery.domain.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 周廷宇
 */
@Table(name = "lottery_record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

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

    public Record() {
    }

    public Record(@NotNull Integer recordType, @NotNull Integer luckyDogId, @NotNull Date luckyTime, @NotNull Integer prizeId) {
        this.recordType = recordType;
        this.luckyDogId = luckyDogId;
        this.luckyTime = luckyTime;
        this.prizeId = prizeId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
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
                "recordId=" + recordId +
                ", recordType=" + recordType +
                ", luckyDogId=" + luckyDogId +
                ", luckyTime=" + luckyTime +
                ", prizeId=" + prizeId +
                '}';
    }
}
