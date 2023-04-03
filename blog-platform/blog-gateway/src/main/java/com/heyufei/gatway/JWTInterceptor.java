//package gatway;
//
//import com.auth0.jwt.exceptions.AlgorithmMismatchException;
//import com.auth0.jwt.exceptions.SignatureVerificationException;
//import com.auth0.jwt.exceptions.TokenExpiredException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.heyufei.common.util.JwtUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author HeYuFei
// * @since 2023-03-30  19:44
// */
//public class JWTInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String JWT = request.getHeader("Authorization");
//        try {
//            // 1.校验JWT字符串
//            DecodedJWT decodedJWT = JwtUtils.generateToken(JWT);
//            // 2.取出JWT字符串载荷中的随机token，从Redis中获取用户信息
//
//
//            return true;
//        } catch (SignatureVerificationException e) {
//            System.out.println("无效签名");
//            e.printStackTrace();
//        } catch (TokenExpiredException e) {
//            System.out.println("token已经过期");
//            e.printStackTrace();
//        } catch (AlgorithmMismatchException e) {
//            System.out.println("算法不一致");
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.out.println("token无效");
//            e.printStackTrace();
//        }
//        return false;
//    }
//}
