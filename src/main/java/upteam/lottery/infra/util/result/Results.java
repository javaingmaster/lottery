package upteam.lottery.infra.util.result;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * @author zty
 * <p>response for http request</p>
 */
public class Results implements Serializable {

    public Results() {
    }

    /**
     * <p>success request 200</p>
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<T>(data, HttpStatus.OK);
    }

    /**
     * <p>success request 200</p>
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<T>(HttpStatus.OK);
    }

    /**
     * <p>success create 201</p>
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> created(T data) {
        return new ResponseEntity<T>(data, HttpStatus.CREATED);
    }

    /**
     * <p>success delete 204</p>
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> deleted(T data) {
        return new ResponseEntity<T>(data, HttpStatus.NO_CONTENT);
    }

    /**
     * <p>bad request 400</p>
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> invalid(T data) {
        return new ResponseEntity<T>(data, HttpStatus.BAD_REQUEST);
    }

    /**
     * <p>bad request 400</p>
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> invalid() {
        return new ResponseEntity<T>(HttpStatus.BAD_REQUEST);
    }

    /**
     * <P>no authority 401</P>
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> unauthorized() {
        return new ResponseEntity<T>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * <p>forbidden request 403/p>
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> forbidden() {
        return new ResponseEntity<T>(HttpStatus.FORBIDDEN);
    }

    /**
     * <p>server error 500</p>
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> error(T data) {
        return new ResponseEntity<T>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * <p>server error 500</p>
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> error() {
        return new ResponseEntity<T>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
