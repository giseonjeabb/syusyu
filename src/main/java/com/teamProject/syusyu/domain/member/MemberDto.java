package com.teamProject.syusyu.domain.member;

import java.time.LocalDateTime;
import java.util.Objects;

public class MemberDto {
    Integer memberId;
    String lginId;
    String lginPwd;
    String name;
    String email;
    String role;
    int regrId;
    LocalDateTime regDttm;
    int updrId;
    LocalDateTime updDttm;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getLginId() {
        return lginId;
    }

    public void setLginId(String lginId) {
        this.lginId = lginId;
    }

    public String getLginPwd() {
        return lginPwd;
    }

    public void setLginPwd(String lginPwd) {
        this.lginPwd = lginPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getRegrId() {
        return regrId;
    }

    public void setRegrId(int regrId) {
        this.regrId = regrId;
    }

    public LocalDateTime getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(LocalDateTime regDttm) {
        this.regDttm = regDttm;
    }

    public int getUpdrId() {
        return updrId;
    }

    public void setUpdrId(int updrId) {
        this.updrId = updrId;
    }

    public LocalDateTime getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(LocalDateTime updDttm) {
        this.updDttm = updDttm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return regrId == memberDto.regrId && updrId == memberDto.updrId && Objects.equals(memberId, memberDto.memberId) && Objects.equals(lginId, memberDto.lginId) && Objects.equals(lginPwd, memberDto.lginPwd) && Objects.equals(name, memberDto.name) && Objects.equals(email, memberDto.email) && Objects.equals(role, memberDto.role) && Objects.equals(regDttm, memberDto.regDttm) && Objects.equals(updDttm, memberDto.updDttm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, lginId, lginPwd, name, email, role, regrId, regDttm, updrId, updDttm);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "memberId=" + memberId +
                ", lginId=" + lginId +
                ", lginPwd='" + lginPwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", regrId=" + regrId +
                ", regDttm=" + regDttm +
                ", updrId=" + updrId +
                ", updDttm=" + updDttm +
                '}';
    }
}
