package com.lewandowski.budget.custom.handler;

import com.lewandowski.budget.model.User;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private User user;

    public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
        super(user);

        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public OnRegistrationCompleteEvent setAppUrl(String appUrl) {
        this.appUrl = appUrl;
        return this;
    }

    public Locale getLocale() {
        return locale;
    }

    public OnRegistrationCompleteEvent setLocale(Locale locale) {
        this.locale = locale;
        return this;
    }

    public User getUser() {
        return user;
    }

    public OnRegistrationCompleteEvent setUser(User user) {
        this.user = user;
        return this;
    }
}
