package com.casestudy3_25feb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy 
public class AuditService {

    public AuditService() {
        System.out.println("AuditService Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Audit Service Initialized");
    }

    public void audit(String message) {
        System.out.println("AUDIT LOG: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Audit Service Destroyed");
    }
}
