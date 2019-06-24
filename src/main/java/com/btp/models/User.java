package com.btp.models;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

    private static final long serialVersionUID = 3737917300502224962L;

    private int userId;
    private String fullName;
    private String email;
    private String password;
    private String school;
    private int isActive;
    private Professional professional;

    public User() {
    }

    public User(int userId, String fullName, String email, String password, String school, int isActive,
                Professional professional) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.school = school;
        this.isActive = isActive;
        this.professional = professional;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", fullName=" + fullName + ", password=" + password + ", school=" + school
                + ", userId=" + userId + ", isActive=" + isActive + ", professional=" + professional + "]";
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the isActive
     */
    public int getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.<GrantedAuthority> emptyList();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * @return the professional
     */
    public Professional getProfessional() {
        return professional;
    }

    /**
     * @param professional the professional to set
     */
    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}