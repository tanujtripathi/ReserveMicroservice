package com.bt.appointment.dto;

import java.io.Serializable;

public class ListAvailableAppointment implements Serializable {
    private ListAvailableAppointmentResponse listAvailableAppointmentResponse = new ListAvailableAppointmentResponse();

    public ListAvailableAppointment() {
    }

    public ListAvailableAppointmentResponse getListAvailableAppointmentResponse() {
        return listAvailableAppointmentResponse;
    }

    public void setListAvailableAppointmentResponse(ListAvailableAppointmentResponse listAvailableAppointmentResponse) {
        this.listAvailableAppointmentResponse = listAvailableAppointmentResponse;
    }
}