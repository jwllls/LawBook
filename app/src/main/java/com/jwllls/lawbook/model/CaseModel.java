package com.jwllls.lawbook.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by jwllls on 2017/10/23.
 */

public class CaseModel extends BmobObject {

    private String initialRecord;
    private String caseName;
    private String caseNo;
    private String clientName;
    private String clientContact;
    private String clientAddress;
    private String lawsuitStatus;
    private String queryPassword;
    private String queryAddress;
    private String attenEvent;

    private String firstSummons;
    private String firstSession;
    private String rightStop;
    private String quoteStop;
    private String appealStop;
    private String counterclaimStop;
    private String sealupDate;

    private String judgeContact;
    private String clerkContact;
    private String lawsuitAddress;
    private String lawyerContact;
    private String litigantContact;
    private String backlog;

    private String eventTimeLine;
    private String occurDate;
    private String eventType;
    private String upDateContent;
    private String remark;


    private String nick;
    private String phone;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInitialRecord() {
        return initialRecord;
    }

    public void setInitialRecord(String initialRecord) {
        this.initialRecord = initialRecord;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getLawsuitStatus() {
        return lawsuitStatus;
    }

    public void setLawsuitStatus(String lawsuitStatus) {
        this.lawsuitStatus = lawsuitStatus;
    }

    public String getQueryPassword() {
        return queryPassword;
    }

    public void setQueryPassword(String queryPassword) {
        this.queryPassword = queryPassword;
    }

    public String getQueryAddress() {
        return queryAddress;
    }

    public void setQueryAddress(String queryAddress) {
        this.queryAddress = queryAddress;
    }

    public String getAttenEvent() {
        return attenEvent;
    }

    public void setAttenEvent(String attenEvent) {
        this.attenEvent = attenEvent;
    }

    public String getFirstSummons() {
        return firstSummons;
    }

    public void setFirstSummons(String firstSummons) {
        this.firstSummons = firstSummons;
    }

    public String getFirstSession() {
        return firstSession;
    }

    public void setFirstSession(String firstSession) {
        this.firstSession = firstSession;
    }

    public String getRightStop() {
        return rightStop;
    }

    public void setRightStop(String rightStop) {
        this.rightStop = rightStop;
    }

    public String getQuoteStop() {
        return quoteStop;
    }

    public void setQuoteStop(String quoteStop) {
        this.quoteStop = quoteStop;
    }

    public String getAppealStop() {
        return appealStop;
    }

    public void setAppealStop(String appealStop) {
        this.appealStop = appealStop;
    }

    public String getCounterclaimStop() {
        return counterclaimStop;
    }

    public void setCounterclaimStop(String counterclaimStop) {
        this.counterclaimStop = counterclaimStop;
    }

    public String getSealupDate() {
        return sealupDate;
    }

    public void setSealupDate(String sealupDate) {
        this.sealupDate = sealupDate;
    }

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
