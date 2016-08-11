package com.rainbow.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by rainbow on 2016/8/9.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class GlobalInteceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(GlobalInteceptor.class);

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        logger.info("进入全局拦截器，放行所有请求");
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        logger.info("进入全局拦截器，处理所有controller请求");
        httpServletRequest.setCharacterEncoding("UTF-8");

    }

    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("全局拦截器的后续请求，清除缓存");

    }
}
