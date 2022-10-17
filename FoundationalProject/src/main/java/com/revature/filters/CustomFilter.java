package com.revature.filters;

import javax.servlet.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[LOG] - CustomFilter was Initialized");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("[LOG] - CustomFilter intercepts web request at " + LocalDateTime.now());
        req.setAttribute("was-filtered", true);
        // resp.setHeader("example-response-header", "some-example-value");
        chain.doFilter(req,resp);

    }
}
