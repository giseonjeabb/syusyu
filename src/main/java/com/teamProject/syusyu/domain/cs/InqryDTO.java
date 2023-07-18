package com.teamProject.syusyu.domain.cs;

import java.util.Date;
import java.util.Objects;

public class InqryDTO {
    private Integer inqryNo; // INQRY_NO 문의 글 번호
    private String inqryTp;  // INQRY_TP 문의 유형
    private String title;     // TITLE 제목
    private String content;   // CONTENT 내용
    private String atchFile; // ATCH_FILE 첨부 파일
    private String inqryYn; // INQRY_YN 처리 상태
    private String ansCn;// ANS_CN  답변 내용
    private Integer ansrId; // ANSR_ID  답변자
    private Date ansDttm; // ANS_DTTM  답변 일시
    private Integer ordDtl_no; // ORD_DTL_NO 주문 상세 번호
    private String email; // EMAIL
    private String mp_no; // MP_NO 휴대폰 번호
    private Date regDttm; // REG_DTTM  등록 일시
    private Integer regrId; // REGR_ID  등록자 아이디
    private Date updDttm; // UPD_DTTM  수정 일시
    private Integer updrId; // UPDR_ID 수정자


    public InqryDTO() {}

    public InqryDTO(Integer inqryNo, String inqryTp, String title, String content, String atchFile, String inqryYn, String ansCn, Integer ansrId, Date ansDttm, Integer ordDtl_no, String email, String mp_no, Date regDttm, Integer regrId, Date updDttm, Integer updrId) {
        this.inqryNo = inqryNo;
        this.inqryTp = inqryTp;
        this.title = title;
        this.content = content;
        this.atchFile = atchFile;
        this.inqryYn = inqryYn;
        this.ansCn = ansCn;
        this.ansrId = ansrId;
        this.ansDttm = ansDttm;
        this.ordDtl_no = ordDtl_no;
        this.email = email;
        this.mp_no = mp_no;
        this.regDttm = regDttm;
        this.regrId = regrId;
        this.updDttm = updDttm;
        this.updrId = updrId;
    }

    public Integer getInqryNo() {
        return inqryNo;
    }

    public void setInqryNo(Integer inqryNo) {
        this.inqryNo = inqryNo;
    }

    public String getInqryTp() {
        return inqryTp;
    }

    public void setInqryTp(String inqryTp) {
        this.inqryTp = inqryTp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAtchFile() {
        return atchFile;
    }

    public void setAtchFile(String atchFile) {
        this.atchFile = atchFile;
    }

    public String getInqryYn() {
        return inqryYn;
    }

    public void setInqryYn(String inqryYn) {
        this.inqryYn = inqryYn;
    }

    public String getAnsCn() {
        return ansCn;
    }

    public void setAnsCn(String ansCn) {
        this.ansCn = ansCn;
    }

    public Integer getAnsrId() {
        return ansrId;
    }

    public void setAnsrId(Integer ansrId) {
        this.ansrId = ansrId;
    }

    public Date getAnsDttm() {
        return ansDttm;
    }

    public void setAnsDttm(Date ansDttm) {
        this.ansDttm = ansDttm;
    }

    public Integer getOrdDtl_no() {
        return ordDtl_no;
    }

    public void setOrdDtl_no(Integer ordDtl_no) {
        this.ordDtl_no = ordDtl_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMp_no() {
        return mp_no;
    }

    public void setMp_no(String mp_no) {
        this.mp_no = mp_no;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public Integer getRegrId() {
        return regrId;
    }

    public void setRegrId(Integer regrId) {
        this.regrId = regrId;
    }

    public Date getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(Date updDttm) {
        this.updDttm = updDttm;
    }

    public Integer getUpdrId() {
        return updrId;
    }

    public void setUpdrId(Integer updrId) {
        this.updrId = updrId;
    }

    @Override
    public String toString() {
        return "InqryDTO{" +
                "inqryNo=" + inqryNo +
                ", inqryTp='" + inqryTp + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", atchFile='" + atchFile + '\'' +
                ", inqryYn='" + inqryYn + '\'' +
                ", ansCn='" + ansCn + '\'' +
                ", ansrId=" + ansrId +
                ", ansDttm=" + ansDttm +
                ", ordDtl_no=" + ordDtl_no +
                ", email='" + email + '\'' +
                ", mp_no='" + mp_no + '\'' +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InqryDTO inqryDTO = (InqryDTO) o;
        return Objects.equals(inqryNo, inqryDTO.inqryNo) && Objects.equals(inqryTp, inqryDTO.inqryTp) && Objects.equals(title, inqryDTO.title) && Objects.equals(content, inqryDTO.content) && Objects.equals(atchFile, inqryDTO.atchFile) && Objects.equals(inqryYn, inqryDTO.inqryYn) && Objects.equals(ansCn, inqryDTO.ansCn) && Objects.equals(ansrId, inqryDTO.ansrId) && Objects.equals(ansDttm, inqryDTO.ansDttm) && Objects.equals(ordDtl_no, inqryDTO.ordDtl_no) && Objects.equals(email, inqryDTO.email) && Objects.equals(mp_no, inqryDTO.mp_no) && Objects.equals(regDttm, inqryDTO.regDttm) && Objects.equals(regrId, inqryDTO.regrId) && Objects.equals(updDttm, inqryDTO.updDttm) && Objects.equals(updrId, inqryDTO.updrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inqryNo, inqryTp, title, content, atchFile, inqryYn, ansCn, ansrId, ansDttm, ordDtl_no, email, mp_no, regDttm, regrId, updDttm, updrId);
    }
}