package com.lssjzmn.core.context;

import javax.servlet.ServletContextEvent;
import java.util.Locale;


public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {
    public static String CONTEXT_REAL_PATH = null;

    public void contextInitialized(ServletContextEvent event) {
        Locale.setDefault(Locale.CHINA);// 默认中国

        CONTEXT_REAL_PATH = event.getServletContext().getRealPath("");

        System.out.println(CONTEXT_REAL_PATH);
        super.contextInitialized(event);
    }

    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}
