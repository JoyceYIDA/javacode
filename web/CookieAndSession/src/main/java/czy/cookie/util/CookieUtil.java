package czy.cookie.util;

import javax.servlet.http.Cookie;

/**
 * 获取指定名称的cookie对象的工具类
 */

public class CookieUtil {

    public static Cookie getCookieByName(String name, Cookie[] cookies) {
        if(cookies!=null){
            for(Cookie c:cookies){
                if(name.equals(c.getName())){
                    return c;
                }
            }
        }
        return null;
    }
}
