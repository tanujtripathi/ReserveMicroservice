package com.bt.appointment.dto;

import java.io.Serializable;
import java.util.ArrayList;


public class GetappointmentDetailsResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Appointment Appointment;
    private RequestLineMessageInfo requestLineMessageInfo;

    public GetappointmentDetailsResponse() {

    }

    public Appointment getAppointment() {
        return Appointment;
    }

    public void setAppointment(Appointment appointment) {
        Appointment = appointment;
    }

    public RequestLineMessageInfo getRequestLineMessageInfo() {
        return requestLineMessageInfo;
    }

    public void setRequestLineMessageInfo(
            RequestLineMessageInfo requestLineMessageInfo) {
        this.requestLineMessageInfo = requestLineMessageInfo;
    }
}
