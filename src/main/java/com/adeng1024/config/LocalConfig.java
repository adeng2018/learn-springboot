package com.adeng1024.config;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocalConfig implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        Locale locale= Locale.getDefault();
        if(!StringUtils.isEmpty(lang)){
            String[] langArray = lang.split("_");
            locale = new Locale(langArray[0], langArray[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
