package com.example.northwind.ShopApp.security;

public enum ApplicationUserPermission {

    USER_WRITE("user:write"),
    USER_READ("user:read"),
    ADMIN_WRITE("admin:write"),
    ADMIN_READ("admin:read");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
