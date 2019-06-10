package com.bt.appointment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ListAvailableAppointmentResponse implements Serializable {

    @JsonProperty("appointment")
    private List<Appointment> Appointment = new ArrayList<>();

    @JsonProperty("requestLineMessageInfo")
    private RequestLineMessageInfo requestLineMessageInfo = new RequestLineMessageInfo();

    public ListAvailableAppointmentResponse() {
    }

    public List<Appointment> getAppointment() {
        return Appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        Appointment = appointment;
    }

    public RequestLineMessageInfo getRequestLineMessageInfo() {
        return requestLineMessageInfo;
    }

    public void setRequestLineMessageInfo(RequestLineMessageInfo requestLineMessageInfo) {
        this.requestLineMessageInfo = requestLineMessageInfo;
    }

}
