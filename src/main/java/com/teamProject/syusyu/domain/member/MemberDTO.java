package com.teamProject.syusyu.domain.member;

import java.time.LocalDateTime;
import java.util.Objects;

public class MemberDTO {
    // member 테이블의 컬럼
    private Integer mbrId;
    private String lginId;
    private String lginPwd;
    private String name;
    private String email;
    private String role;
    private int regrId;
    private LocalDateTime regDttm;
    private int updrId;
    private LocalDateTime updDttm;

    // mbr_info 테이블의 컬럼
    private String nickNm;
    private String profPic;
    private Integer height;
    private Integer shoeSize;
    private String mpNo;
    private String birth;
    private String sex;
    private Integer grdCd;
    private int totPnt;
    private String adSmsYn;
    private String adEmailYn;
    private String agrePsnlInfoYn;
    private String agre3rdOfrYn;
    private String zzzMbrYn;
    private LocalDateTime zzzProcDttm;

    public MemberDTO() { }

    public MemberDTO(String lginId, String lginPwd, String name, String email, String role, Integer shoeSize, String mpNo, String birth, String sex) {
        this.lginId = lginId;
        this.lginPwd = lginPwd;
        this.name = name;
        this.email = email;
        this.role = role;
        this.shoeSize = shoeSize;
        this.mpNo = mpNo;
        this.birth = birth;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return totPnt == memberDTO.totPnt && Objects.equals(mbrId, memberDTO.mbrId) && Objects.equals(lginId, memberDTO.lginId) && Objects.equals(lginPwd, memberDTO.lginPwd) && Objects.equals(name, memberDTO.name) && Objects.equals(email, memberDTO.email) && Objects.equals(role, memberDTO.role) && Objects.equals(nickNm, memberDTO.nickNm) && Objects.equals(profPic, memberDTO.profPic) && Objects.equals(height, memberDTO.height) && Objects.equals(shoeSize, memberDTO.shoeSize) && Objects.equals(mpNo, memberDTO.mpNo) && Objects.equals(birth, memberDTO.birth) && Objects.equals(sex, memberDTO.sex) && Objects.equals(grdCd, memberDTO.grdCd) && Objects.equals(adSmsYn, memberDTO.adSmsYn) && Objects.equals(adEmailYn, memberDTO.adEmailYn) && Objects.equals(agrePsnlInfoYn, memberDTO.agrePsnlInfoYn) && Objects.equals(agre3rdOfrYn, memberDTO.agre3rdOfrYn) && Objects.equals(zzzMbrYn, memberDTO.zzzMbrYn) && Objects.equals(zzzProcDttm, memberDTO.zzzProcDttm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mbrId, lginId, lginPwd, name, email, role, nickNm, profPic, height, shoeSize, mpNo, birth, sex, grdCd, totPnt, adSmsYn, adEmailYn, agrePsnlInfoYn, agre3rdOfrYn, zzzMbrYn, zzzProcDttm);
    }

    public Integer getMbrId() {
        return mbrId;
    }

    public void setMbrId(Integer mbrId) {
        this.mbrId = mbrId;
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

    public String getNickNm() {
        return nickNm;
    }

    public void setNickNm(String nickNm) {
        this.nickNm = nickNm;
    }

    public String getProfPic() {
        return profPic;
    }

    public void setProfPic(String profPic) {
        this.profPic = profPic;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(Integer shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getMpNo() {
        return mpNo;
    }

    public void setMpNo(String mpNo) {
        this.mpNo = mpNo;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getGrdCd() {
        return grdCd;
    }

    public void setGrdCd(Integer grdCd) {
        this.grdCd = grdCd;
    }

    public int getTotPnt() {
        return totPnt;
    }

    public void setTotPnt(int totPnt) {
        this.totPnt = totPnt;
    }

    public String getAdSmsYn() {
        return adSmsYn;
    }

    public void setAdSmsYn(String adSmsYn) {
        this.adSmsYn = adSmsYn;
    }

    public String getAdEmailYn() {
        return adEmailYn;
    }

    public void setAdEmailYn(String adEmailYn) {
        this.adEmailYn = adEmailYn;
    }

    public String getAgrePsnlInfoYn() {
        return agrePsnlInfoYn;
    }

    public void setAgrePsnlInfoYn(String agrePsnlInfoYn) {
        this.agrePsnlInfoYn = agrePsnlInfoYn;
    }

    public String getAgre3rdOfrYn() {
        return agre3rdOfrYn;
    }

    public void setAgre3rdOfrYn(String agre3rdOfrYn) {
        this.agre3rdOfrYn = agre3rdOfrYn;
    }

    public String getZzzMbrYn() {
        return zzzMbrYn;
    }

    public void setZzzMbrYn(String zzzMbrYn) {
        this.zzzMbrYn = zzzMbrYn;
    }

    public LocalDateTime getZzzProcDttm() {
        return zzzProcDttm;
    }

    public void setZzzProcDttm(LocalDateTime zzzProcDttm) {
        this.zzzProcDttm = zzzProcDttm;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberId=" + mbrId +
                ", lginId='" + lginId + '\'' +
                ", lginPwd='" + lginPwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", regrId=" + regrId +
                ", regDttm=" + regDttm +
                ", updrId=" + updrId +
                ", updDttm=" + updDttm +
                ", nickNm='" + nickNm + '\'' +
                ", profPic='" + profPic + '\'' +
                ", height=" + height +
                ", shoeSize=" + shoeSize +
                ", mpNo='" + mpNo + '\'' +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", grdCd=" + grdCd +
                ", totPnt=" + totPnt +
                ", adSmsYn='" + adSmsYn + '\'' +
                ", adEmailYn='" + adEmailYn + '\'' +
                ", agrePsnlInfoYn='" + agrePsnlInfoYn + '\'' +
                ", agre3rdOfrYn='" + agre3rdOfrYn + '\'' +
                ", zzzMbrYn='" + zzzMbrYn + '\'' +
                ", zzzProcDttm=" + zzzProcDttm +
                '}';
    }
}
