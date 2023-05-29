package com.newstyle.shopping.config;

public class SessionManager {
    private static SessionManager instance;
    private boolean isAuthenticated;
    
    private SessionManager() {
        isAuthenticated = false;
    }
    
    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
    
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}

