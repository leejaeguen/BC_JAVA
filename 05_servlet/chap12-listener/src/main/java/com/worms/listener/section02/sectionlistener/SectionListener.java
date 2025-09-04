package com.worms.listener.section02.sectionlistener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SectionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session Create!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session Destroy!");
    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session attribute add!");
        System.out.println("session에 추가 된 attr: " + event.getName() + ", value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session attribute remove!");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("attribute Replace!");
    }
}
