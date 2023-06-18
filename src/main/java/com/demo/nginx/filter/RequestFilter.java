package com.demo.nginx.filter;

import com.demo.nginx.controller.NginxController;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(NginxController.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Filtering requests init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
       HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

       // to confirm we get the headers set by nginx
       httpServletRequest
               .getHeaderNames()
               .asIterator()
               .forEachRemaining(
                       header -> logger.info("Header {}: {}", header, httpServletRequest.getHeader(header)));

       // tells nginx to expire content straight away
        httpServletResponse.setHeader("Expires", "0");
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
