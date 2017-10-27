package com.jwllls.lawbook.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by jwllls on 2017/10/23.
 */

public class CaseModel extends BmobObject implements Serializable {

    private String nick;  //昵称
    private String phone;//电话

    private String initialRecord; //初始记录
    private String caseName; //案件名
    private String caseNo;  //案号
    private String clientName; //委托人名称
    private String clientContact; //委托人经办及联系方式
    private String clientAddress; //委托人地址
    private String lawsuitStatus; //诉讼地位
    private String queryPassword; //查询面膜
    private String queryAddress; //查询地址
    private String attenEvent;  //注意事项

    private String procedure;  //程序阶段
    private String firstSummons; //首次收到传票日
    private String firstSession;    //首次开庭日
    private String rightStop;   //管辖权截止日
    private String quoteStop;   //举证截止日
    private String appealStop; //上诉截止日
    private String counterclaimStop; //反诉截止日
    private String sealupDate; //查封到期日


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

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
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


}
