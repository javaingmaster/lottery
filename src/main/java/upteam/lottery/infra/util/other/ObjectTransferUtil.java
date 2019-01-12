package upteam.lottery.infra.util.other;

import upteam.lottery.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周廷宇
 */
public class ObjectTransferUtil {
    public static List<Integer> userToInt(List<User> users) {
        List<Integer> result = new ArrayList<>();
        for (User item : users) {
            result.add(item.getUserId());
        }
        return result;
    }
}
