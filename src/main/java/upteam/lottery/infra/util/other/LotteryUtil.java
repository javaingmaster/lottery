package upteam.lottery.infra.util.other;

import upteam.lottery.domain.entity.Record;
import upteam.lottery.domain.entity.Rule;
import upteam.lottery.domain.entity.RuleObject;
import upteam.lottery.domain.entity.RulePrize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * @author 李旭峰
 */
public class LotteryUtil {

    static int[] userId;
    static int[] appointedUserId;
    static int[] groupId;
    static int[] appointedGroupId;
    static int[] prizeId;
    // 自定义用户概率
    static double[] customUserProbability;
    static double[] customGroupProbability;
    // 自定义奖品概率
    static double[] customPrizeProbability;
    // 用户平均概率
    static double avgUserProbability = 100d;
    static double avgGroupProbability = 100d;
    // 奖品平均概率
    static double avgPrizeProbability = 100d;
    // 参与抽奖用户数量
    static int users;
    static int groups;
    static int prizes;
    static int userNumber;
    static int groupNumber;
    static int prizeLevel;
    static Date date;

    public static List<Record> personalRepeatableLottery(Rule rule, List<RuleObject> ruleObjects, List<RulePrize> rulePrizes) {
        Record record = new Record();
        double userRandom = Math.random() * 100;
        double prizeRandom = Math.random() * 100;
        parse(rule, ruleObjects, rulePrizes);
        double userProbability = avgUserProbability;
        if (userNumber == 0) {
            for (int i = 0; i < users; i++) {
                if (userRandom <= userProbability) {
                    record.setLuckyDogId(userId[i]);
                    record.setLuckyTime(date);
                    record.setRecordType(0);
                    break;
                } else {
                    userProbability += avgUserProbability;
                }
            }
        } else {
            for (int i = 0; i < users; i++) {
                if (userRandom <= userProbability) {
                    record.setLuckyDogId(userId[i]-1);
                    record.setLuckyTime(date);
                    record.setRecordType(0);
                    break;
                } else {
                    boolean flag = true;
                    for (int j = 0; j < userNumber; j++) {
                        if (i + 1 == appointedUserId[j]) {
                            userProbability += customUserProbability[j];
                            flag = false;
                        }
                    }
                    if (flag) {
                        userProbability += avgUserProbability;
                    }
                }
            }
        }

        double prizeProbability = avgUserProbability;
        for (int i = 0; i < prizes; i++) {
            if (prizeRandom <= prizeProbability) {
                if (avgPrizeProbability > 0) {
                    record.setPrizeId(0);
                    break;
                } else {
                    record.setPrizeId(i-1);
                    break;
                }
            } else {
                boolean flag = true;
                for (int j = 0; j < prizeLevel; j++) {
                    if (i == prizeId[j]) {
                        prizeProbability += customPrizeProbability[j];
                        flag = false;
                    }
                }
                if (flag) {
                    prizeProbability += avgPrizeProbability;
                }
            }
        }

        List<Record> result=new ArrayList<>();
        result.add(record);
        return result;
    }

    public static List<Record> personalUnRepeatableLottery(Rule rule, List<RuleObject> ruleObjects,
                                                           List<RulePrize> rulePrizes) {
        Record record = new Record();
        List<Integer> userIdList = new ArrayList<Integer>();
        List<Integer> appointedUserIdList = new ArrayList<Integer>();
        parse(rule, ruleObjects, rulePrizes);
        p: while (users > 0) {
            double userRandom = Math.random() * 100;
            double prizeRandom = Math.random() * 100;

            double userProbability = avgUserProbability;
            if (userNumber == 0) {
                for (int i = 0; i < users; i++) {
                    if (userRandom <= userProbability) {
                        if (userIdList.contains(userId[i])) {
                            continue p;
                        } else {
                            record.setLuckyDogId(userId[i]);
                            record.setLuckyTime(date);
                            record.setRecordType(0);
                            userIdList.add(userId[i]);
                            System.out.println(userIdList);
                            users--;
                            int temp = userId[i];
                            userId[i] = userId[users];
                            userId[users] = temp;
                        }
                    } else {
                        userProbability += avgUserProbability;
                    }
                }
            } else {
                for (int i=0; i < users; i++) {
                    if (userRandom <= userProbability) {
                        if (appointedUserIdList.contains(userId[i])) {
                            continue p;
                        } else {
                            record.setLuckyDogId(userId[i]-1);
                            record.setLuckyTime(date);
                            record.setRecordType(0);
                            appointedUserIdList.add(userId[i]);
                            users--;
                        }
                    } else {
                        boolean flag = true;
                        for (int j = 0; j < userNumber; j++) {
                            if (i + 1 == appointedUserId[j]) {
                                if(!appointedUserIdList.contains(appointedUserId[j])){
                                    userProbability += customUserProbability[j];
                                    flag = false;
                                }
                            }
                        }
                        if (flag) {
                            userProbability += avgUserProbability;
                        }
                    }
                }
            }

            double prizeProbability = avgPrizeProbability;
            for (int i = 0; i < prizes; i++) {
                if (prizeRandom <= prizeProbability) {
                    if (avgPrizeProbability > 0) {
                        record.setPrizeId(0);;
                        break;
                    } else {
                        record.setPrizeId(i-1);;
                        break;
                    }
                } else {
                    boolean flag = true;
                    for (int j = 0; j < prizeLevel; j++) {
                        if (i == prizeId[j]) {
                            prizeProbability += customPrizeProbability[j];
                            flag = false;
                        }
                    }
                    if (flag) {
                        prizeProbability += avgPrizeProbability;
                    }
                }
            }
        }
        List<Record> result=new ArrayList<>();
        result.add(record);
        return result;
    }

    public static List<Record> repeatableLottery(Rule rule, List<RuleObject> ruleObjects, List<RulePrize> rulePrizes){
        Record record = new Record();
        double groupRandom = Math.random() * 100;
        double prizeRandom = Math.random() * 100;
        parse(rule, ruleObjects, rulePrizes);
        double groupProbability = avgGroupProbability;
        if (groupNumber == 0) {
            for (int i = 0; i < groups; i++) {
                if (groupRandom <= groupProbability) {
                    record.setLuckyDogId(groupId[i]);
                    record.setLuckyTime(date);
                    record.setRecordType(1);
                    break;
                } else {
                    groupProbability += avgGroupProbability;
                }
            }
        } else {
            for (int i = 0; i < groups; i++) {
                if (groupRandom <= groupProbability) {
                    record.setLuckyDogId(groupId[i]-1);
                    record.setLuckyTime(date);
                    record.setRecordType(1);
                    break;
                } else {
                    boolean flag = true;
                    for (int j = 0; j < groupNumber; j++) {
                        if (i + 1 == appointedGroupId[j]) {
                            groupProbability += customGroupProbability[j];
                            flag = false;
                        }
                    }
                    if (flag) {
                        groupProbability += avgGroupProbability;
                    }
                }
            }
        }

        double prizeProbability = avgGroupProbability;
        for (int i = 0; i < prizes; i++) {
            if (prizeRandom <= prizeProbability) {
                if (avgPrizeProbability > 0) {
                    record.setPrizeId(0);
                    break;
                } else {
                    record.setPrizeId(i-1);
                    break;
                }
            } else {
                boolean flag = true;
                for (int j = 0; j < prizeLevel; j++) {
                    if (i == prizeId[j]) {
                        prizeProbability += customPrizeProbability[j];
                        flag = false;
                    }
                }
                if (flag) {
                    prizeProbability += avgPrizeProbability;
                }
            }
        }

        List<Record> result=new ArrayList<>();
        result.add(record);
        return result;

    }

    public static List<Record> unrepeatableLottery(Rule rule, List<RuleObject> ruleObjects, List<RulePrize> rulePrizes){
        Record record = new Record();
        List<Integer> userIdList = new ArrayList<Integer>();
        List<Integer> appointedUserIdList = new ArrayList<Integer>();
        parse(rule, ruleObjects, rulePrizes);
        p: while (groups > 0) {
            double userRandom = Math.random() * 100;
            double prizeRandom = Math.random() * 100;

            double userProbability = avgGroupProbability;
            if (groupNumber == 0) {
                for (int i = 0; i < groups; i++) {
                    if (userRandom <= userProbability) {
                        if (userIdList.contains(groupId[i])) {
                            continue p;
                        } else {
                            record.setLuckyDogId(groupId[i]);
                            record.setLuckyTime(date);
                            record.setRecordType(1);
                            userIdList.add(groupId[i]);
                            System.out.println(userIdList);
                            groups--;
                            int temp = groupId[i];
                            groupId[i] = groupId[groups];
                            groupId[groups] = temp;
                        }
                    } else {
                        userProbability += avgGroupProbability;
                    }
                }
            } else {
                for (int i=0; i < groups; i++) {
                    if (userRandom <= userProbability) {
                        if (appointedUserIdList.contains(groupId[i])) {
                            continue p;
                        } else {
                            record.setLuckyDogId(groupId[i]-1);
                            record.setLuckyTime(date);
                            record.setRecordType(1);
                            appointedUserIdList.add(groupId[i]);
                            groups--;
                        }
                    } else {
                        boolean flag = true;
                        for (int j = 0; j < groupNumber; j++) {
                            if (i + 1 == appointedGroupId[j]) {
                                if(!appointedUserIdList.contains(appointedGroupId[j])){
                                    userProbability += customGroupProbability[j];
                                    flag = false;
                                }
                            }
                        }
                        if (flag) {
                            userProbability += avgGroupProbability;
                        }
                    }
                }
            }

            double prizeProbability = avgPrizeProbability;
            for (int i = 0; i < prizes; i++) {
                if (prizeRandom <= prizeProbability) {
                    if (avgPrizeProbability > 0) {
                        record.setPrizeId(0);;
                        break;
                    } else {
                        record.setPrizeId(i-1);;
                        break;
                    }
                } else {
                    boolean flag = true;
                    for (int j = 0; j < prizeLevel; j++) {
                        if (i == prizeId[j]) {
                            prizeProbability += customPrizeProbability[j];
                            flag = false;
                        }
                    }
                    if (flag) {
                        prizeProbability += avgPrizeProbability;
                    }
                }
            }
        }

        List<Record> result=new ArrayList<>();
        result.add(record);
        return result;
    }

    private static void parse(Rule rule, List<RuleObject> ruleObjects, List<RulePrize> rulePrizes) {
        users = ruleObjects.size();
        groups = ruleObjects.size();
        userId = new int[users];
        groupId = new int[groups];
        for(int i=0;i<users;i++){
            userId[i] = i+1;
        }
        for(int i=0;i<groups;i++){
            groupId[i] = i+1;
        }

        List<RuleObject> userNumbers=new ArrayList<>();
        for(RuleObject item : ruleObjects){
            if(item.getObjectRatio()!=null){
                userNumbers.add(item);
            }
        }
        userNumber = userNumbers.size();
        appointedUserId = new int[userNumber];
        customUserProbability = new double[userNumber];
        int index=0;
        for(RuleObject item : ruleObjects){
            if(item.getObjectRatio()!=null){
                appointedUserId[index] = item.getLotteryObjectId();
                customUserProbability[index] = item.getObjectRatio();
                avgUserProbability = avgUserProbability - customUserProbability[index];
                index++;
            }
        }
        if (userNumber == 0) {
            avgUserProbability = 100d;
        }

        List<RuleObject> groupNumbers=new ArrayList<>();
        for(RuleObject item : ruleObjects){
            if(item.getObjectRatio()!=null){
                groupNumbers.add(item);
            }
        }
        groupNumber = groupNumbers.size();
        appointedGroupId = new int[groupNumber];
        customGroupProbability = new double[groupNumber];
        index=0;
        for(RuleObject item : ruleObjects){
            if(item.getObjectRatio()!=null){
                appointedGroupId[index] = item.getLotteryObjectId();
                customGroupProbability[index] = item.getObjectRatio();
                avgGroupProbability = avgGroupProbability - customGroupProbability[index];
                index++;
            }
        }
        if (groupNumber == 0) {
            avgGroupProbability = 100d;
        }

        prizes = rulePrizes.size();
        prizeId = new int[prizeLevel];
        index = 0;
        List<RulePrize> prizeLevels = new ArrayList<>();
        for(RulePrize item : prizeLevels){
            if(item.getPrizeRatio()!=null){
                prizeLevels.add(item);
            }
        }
        prizeLevel = prizeLevels.size();
        prizeId = new int[prizeLevel];
        customPrizeProbability = new double[prizeLevel];
        index = 0;
        for(RulePrize item : prizeLevels){
            if(item.getPrizeRatio()!=null){
                prizeId[index] = item.getPrizeId();
                customPrizeProbability[index] = item.getPrizeRatio();
                avgPrizeProbability = avgPrizeProbability - customPrizeProbability[index];
                index++;
            }
        }

        appointedUserId = new int[userNumber];
        appointedGroupId = new int[groupNumber];
        prizeId = new int[prizeLevel];
        customUserProbability = new double[userNumber];
        customGroupProbability = new double[groupNumber];
        customPrizeProbability = new double[prizeLevel];
        avgUserProbability = avgUserProbability / (users - userNumber);
        avgGroupProbability = avgGroupProbability / (groups - groupNumber);
        avgPrizeProbability = avgPrizeProbability / (prizes - prizeLevel);
    }
}
