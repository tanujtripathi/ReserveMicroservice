package com.bt.appointment.dto;

public class ReserveAppointmentResponse {

    public ReserveAppointmentResponse() {
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public RequestLineMessageInfo getRequestLineMessageInfo() {
        return requestLineMessageInfo;
    }

    public void setRequestLineMessageInfo(RequestLineMessageInfo requestLineMessageInfo) {
        this.requestLineMessageInfo = requestLineMessageInfo;
    }

    private Appointment appointment = new Appointment();
    private RequestLineMessageInfo requestLineMessageInfo = new RequestLineMessageInfo();

}
