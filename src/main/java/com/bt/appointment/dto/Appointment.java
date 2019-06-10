package com.bt.appointment.dto;

public class Appointment {
	private String refId;

	private String appointmentDate;
    private String appointmentTimeslot;

    public Appointment() {
    }

    public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}
    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTimeslot() {
        return appointmentTimeslot;
    }

    public void setAppointmentTimeslot(String appointmentTimeslot) {
        this.appointmentTimeslot = appointmentTimeslot;
    }

    @Override
    public String toString() {
        return "AppointmentEntity{" +
                "appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTimeslot='" + appointmentTimeslot + '\'' +
                '}';
    }
}
