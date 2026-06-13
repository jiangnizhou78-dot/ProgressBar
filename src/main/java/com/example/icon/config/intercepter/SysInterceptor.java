package com.example.icon.config.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

public class SysInterceptor implements HandlerInterceptor {

   /* @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path=request.getRequestURI();
        System.out.println("path="+path);
        if(handler instanceof HandlerMethod){
            // 判断token是否为空
            String token=request.getHeader("token");
            System.out.println("token="+token);
            if(StringUtil.isNullOrEmpty(token)){
                System.out.println("token为空！");
                throw new RuntimeException("签名验证不存在！");
            }else{
                // 如果token不为空
                Claims claims = JwtUtils.validateJWT(token).getClaims();
                if(claims==null){
                    System.out.println("鉴权失败");
                    throw new RuntimeException("鉴权失败！");
                }else{
                    System.out.println("鉴权成功");
                    return true;
                }
            }
        }else{
            return true;
        }
    }*/
}

