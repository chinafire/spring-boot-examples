package com.leone.boot.security.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author leone
 * @since 2018-04-13
 **/
@Slf4j
@WebFilter
public class AppFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }

    public void destroy() {
        log.info("filter destroy");
    }
}
