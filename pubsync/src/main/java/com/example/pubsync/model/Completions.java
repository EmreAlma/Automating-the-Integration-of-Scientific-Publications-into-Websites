package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class Completions{

    @SerializedName("@sent")
    private String sent;

    @SerializedName("c")
    private C C;

    @SerializedName("@computed")
    private String computed;

    @SerializedName("@total")
    private String total;

    public void setSent(String sent){
        this.sent = sent;
    }

    public String getSent(){
        return sent;
    }

    public void setC(C C){
        this.C = C;
    }

    public C getC(){
        return C;
    }

    public void setComputed(String computed){
        this.computed = computed;
    }

    public String getComputed(){
        return computed;
    }

    public void setTotal(String total){
        this.total = total;
    }

    public String getTotal(){
        return total;
    }
}