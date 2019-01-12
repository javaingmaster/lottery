package upteam.lottery.infra.util.jwt;

import upteam.lottery.domain.entity.User;
import upteam.lottery.infra.constant.AuthorityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 周廷宇
 *
 * <p>jwt util</p>
 */
public class JwtUtil {

    /**
     * @return create token
     */
    public static String createToken(User user) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.DATE, 10);
        Date expiresDate = nowTime.getTime();

        Claims claims = Jwts.claims();
        claims.put("userId", user.getUserId());
        claims.put("userName", user.getUserName());
        claims.put("userAuthority", user.getUserRole());

        claims.setAudience("any");
        claims.setIssuer("zty");

        return Jwts.builder().setClaims(claims).setExpiration(expiresDate)
                .signWith(SignatureAlgorithm.HS512, AuthorityConstant.SECRET)
                .compact();
    }

    /**
     * @param token token
     * @return an instance after parsing token
     */
    public static TokenMessage parseToken(String token) {
        TokenMessage tokenMessage = new TokenMessage();
        Jws<Claims> jws = Jwts.parser().setSigningKey(AuthorityConstant.SECRET).parseClaimsJws(token);

        Claims claims = jws.getBody();
        tokenMessage.setExpiresDate(claims.getExpiration());
        tokenMessage.setUserId((Integer) claims.get("userId"));
        tokenMessage.setUserName((String) claims.get("userName"));
        tokenMessage.setUserAuthority((Integer) claims.get("userAuthority"));

        return tokenMessage;
    }
}
