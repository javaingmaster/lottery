package upteam.lottery.infra.util.aop;

import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;

/**
 * @author 周廷宇
 *
 * <p>annotation util</p>
 */
public class AnnotationUtil {
    /**
     * @param handlerMethod <p>an information class which includes methods, arguments and other params</p>
     * @param classType     <p>type class you need</p>
     * @return <p>an annotation</p>
     */
    public static Annotation getAnnotation(HandlerMethod handlerMethod, Class<? extends Annotation> classType) {
        return handlerMethod.getMethod().getAnnotation(classType);
    }
}
