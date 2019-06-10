package com.bt.appointment.dto;

import java.io.Serializable;

public class GetappointmentDetails implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GetappointmentDetailsResponse getappointmentDetailsResponse = new GetappointmentDetailsResponse();

    public GetappointmentDetails() {
        // TODO Auto-generated constructor stub
    }

    public GetappointmentDetailsResponse getGetappointmentDetailsResponse() {
        return getappointmentDetailsResponse;
    }

    public void setGetappointmentDetailsResponse(
            GetappointmentDetailsResponse getappointmentDetailsResponse) {
        this.getappointmentDetailsResponse = getappointmentDetailsResponse;
    }


}
