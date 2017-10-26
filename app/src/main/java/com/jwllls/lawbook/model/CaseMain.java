package com.jwllls.lawbook.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by jwllls on 2017/10/26.
 */

public class CaseMain extends BmobObject {


    private String judgeContact; //经办法官联系方式
    private String clerkContact; //书记员联系方式
    private String lawsuitAddress; //诉讼地址
    private String lawyerContact; //经办律师联系方式
    private String litigantContact; //对方当事人及联系方式
    private String backlog;//待办事项


    private String eventTimeLine; //事件时间线
    private String occurDate;   //发生日
    private String eventType;   //事件类型
    private String upDateContent; //更新内容
    private String remark;  //备注


    public String getJudgeContact() {
        return judgeContact;
    }

    public void setJudgeContact(String judgeContact) {
        this.judgeContact = judgeContact;
    }

    public String getClerkContact() {
        return clerkContact;
    }

    public void setClerkContact(String clerkContact) {
        this.clerkContact = clerkContact;
    }

    public String getLawsuitAddress() {
        return lawsuitAddress;
    }

    public void setLawsuitAddress(String lawsuitAddress) {
        this.lawsuitAddress = lawsuitAddress;
    }

    public String getLawyerContact() {
        return lawyerContact;
    }

    public void setLawyerContact(String lawyerContact) {
        this.lawyerContact = lawyerContact;
    }

    public String getLitigantContact() {
        return litigantContact;
    }

    public void setLitigantContact(String litigantContact) {
        this.litigantContact = litigantContact;
    }

    public String getBacklog() {
        return backlog;
    }

    public void setBacklog(String backlog) {
        this.backlog = backlog;
    }

    public String getEventTimeLine() {
        return eventTimeLine;
    }

    public void setEventTimeLine(String eventTimeLine) {
        this.eventTimeLine = eventTimeLine;
    }

    public String getOccurDate() {
        return occurDate;
    }

    public void setOccurDate(String occurDate) {
        this.occurDate = occurDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getUpDateContent() {
        return upDateContent;
    }

    public void setUpDateContent(String upDateContent) {
        this.upDateContent = upDateContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
