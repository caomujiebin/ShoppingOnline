package com.springmvc.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/i18n")
public class I18nController {

    @RequestMapping("/sessionLocaleResover")
    public String test(HttpSession session, String request_locale) {

        if(StringUtils.isNotBlank(request_locale)){

            if(StringUtils.equals(request_locale,"zh_CN")){

                Locale local = new Locale("zh","CN");
                session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,local);

            }else if(StringUtils.equals(request_locale,"en_US")){

                Locale local = new Locale("en","US");
                session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,local);
            }

        }else{
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
        }
        return "forward:/index.jsp";
    }
}