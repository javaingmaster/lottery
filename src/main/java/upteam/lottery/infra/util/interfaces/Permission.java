package upteam.lottery.infra.util.interfaces;

import upteam.lottery.infra.constant.AuthorityConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zty
 *
 * <p>authority annotation</p>
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    /**
     * @return return level of authority
     */
    int level() default AuthorityConstant.PUBLIC;
}
