package vn.mila.example.dto;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 11:26 AM
 */
public class UserInfo {

    private String username;
    private String cif;
    private Integer old;

    public String getUsername() {
        return username;
    }

    public UserInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getCif() {
        return cif;
    }

    public UserInfo setCif(String cif) {
        this.cif = cif;
        return this;
    }

    public Integer getOld() {
        return old;
    }

    public UserInfo setOld(Integer old) {
        this.old = old;
        return this;
    }
}
