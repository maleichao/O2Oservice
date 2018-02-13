package com.tykj.member.model;

public class Memberbasicinfo {
    private Integer memberBasicInfoId;

    private Integer memberId;

    private String memberRealName;

    private Byte memberSex;

    private String portraitUrl;

    public Integer getMemberBasicInfoId() {
        return memberBasicInfoId;
    }

    public void setMemberBasicInfoId(Integer memberBasicInfoId) {
        this.memberBasicInfoId = memberBasicInfoId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberRealName() {
        return memberRealName;
    }

    public void setMemberRealName(String memberRealName) {
        this.memberRealName = memberRealName == null ? null : memberRealName.trim();
    }

    public Byte getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(Byte memberSex) {
        this.memberSex = memberSex;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl == null ? null : portraitUrl.trim();
    }
}