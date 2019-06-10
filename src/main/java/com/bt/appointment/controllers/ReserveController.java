package com.bt.appointment.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bt.appointment.dto.Appointment;
import com.bt.appointment.dto.GetappointmentDetails;
import com.bt.appointment.dto.GetappointmentDetailsResponse;
import com.bt.appointment.dto.ListAvailableAppointment;
import com.bt.appointment.dto.MessageInfo;
import com.bt.appointment.dto.RequestLineMessageInfo;
import com.bt.appointment.dto.ReserveAppointmentResponse;
import com.bt.appointment.entity.AppointmentEntity;
import com.bt.appointment.repository.SQLRepository;

@RestController
@RequestMapping("api")
public class ReserveController {

	@Autowired
	SQLRepository sqlRepository;

	@GetMapping("/list")
	public ListAvailableAppointment getAllAppointmentDetails() {

		List<AppointmentEntity> appointments = sqlRepository.findAll();

		ListAvailableAppointment listAvailableAppointment = new ListAvailableAppointment();

		List<Appointment> listAvailableAppointmentDetails = listAvailableAppointment
				.getListAvailableAppointmentResponse().getAppointment();

		appointments.parallelStream().forEach(appointment -> {
			Appointment appointmentDto = new Appointment();
			appointmentDto.setRefId(String.valueOf(appointment.getRefId()));
			appointmentDto.setAppointmentDate(appointment.getDate());
			appointmentDto.setAppointmentTimeslot(appointment.getAm_pm());
			listAvailableAppointmentDetails.add(appointmentDto);
		});

		listAvailableAppointment.getListAvailableAppointmentResponse().setAppointment(listAvailableAppointmentDetails);
		RequestLineMessageInfo requestLineMessageInfo = getRequestLineMessageInfo("200", "Success", "Low");
		listAvailableAppointment.getListAvailableAppointmentResponse()
				.setRequestLineMessageInfo(requestLineMessageInfo);

		return listAvailableAppointment;
	}

	@RequestMapping("/get")
	public GetappointmentDetails get(@RequestParam String app_refId) {

		AppointmentEntity appointment = sqlRepository.findById(Long.valueOf(app_refId)).get();

		GetappointmentDetails getappointmentDetails = new GetappointmentDetails();
		GetappointmentDetailsResponse getappointmentDetailsResponse = new GetappointmentDetailsResponse();

		Appointment aAppointment = new Appointment();
		aAppointment.setRefId(String.valueOf(appointment.getRefId()));
		aAppointment.setAppointmentDate(appointment.getDate());
		aAppointment.setAppointmentTimeslot(appointment.getAm_pm());
		getappointmentDetailsResponse.setAppointment(aAppointment);

		RequestLineMessageInfo requestLineMessageInfo = getRequestLineMessageInfo("200", "Success", "Low");
		getappointmentDetailsResponse.setRequestLineMessageInfo(requestLineMessageInfo);
		getappointmentDetails.setGetappointmentDetailsResponse(getappointmentDetailsResponse);
		return getappointmentDetails;
	}

	// Reserve will call list service and choose one object and make the flag
	// true and return APP RefiD
	@RequestMapping("/reserve")
	public ReserveAppointmentResponse reserve(@RequestParam Map<String, String> queryMap) {
		ReserveAppointmentResponse reserveAppointmentResponse = new ReserveAppointmentResponse();
		List<AppointmentEntity> appointmentEntities = sqlRepository.findByStatus("0");
		if (appointmentEntities.size() == 0) {
			RequestLineMessageInfo requestLineMessageInfo = getRequestLineMessageInfo("500",
					"No Appointments are available", "Medium");
			reserveAppointmentResponse.setRequestLineMessageInfo(requestLineMessageInfo);

		} else {
			AppointmentEntity appointment = appointmentEntities.get(0);
			appointment.setStatus("1");
			appointment = sqlRepository.saveAndFlush(appointment);
			Appointment appointmentDTO = reserveAppointmentResponse.getAppointment();
			appointmentDTO.setAppointmentDate(appointment.getDate());
			appointmentDTO.setAppointmentTimeslot(appointment.getAm_pm());
			appointmentDTO.setRefId(String.valueOf(appointment.getRefId()));
			RequestLineMessageInfo requestLineMessageInfo = getRequestLineMessageInfo("200", "OK", "Medium");
			reserveAppointmentResponse.setRequestLineMessageInfo(requestLineMessageInfo);
			reserveAppointmentResponse.setAppointment(appointmentDTO);
		}
		return reserveAppointmentResponse;
	}

	@RequestMapping("/deleteReservedAppointment")
	public ReserveAppointmentResponse deleteReservedAppointment(@RequestParam("refId") String refId) {
		ReserveAppointmentResponse reserveAppointmentResponse = new ReserveAppointmentResponse();
		AppointmentEntity appointmentEntity = sqlRepository.findById(Long.valueOf(refId)).get();
		appointmentEntity.setStatus("0");
		appointmentEntity = sqlRepository.saveAndFlush(appointmentEntity);
		Appointment appointmentDTO = reserveAppointmentResponse.getAppointment();
		appointmentDTO.setAppointmentDate(appointmentEntity.getDate());
		appointmentDTO.setAppointmentTimeslot(appointmentEntity.getAm_pm());
		RequestLineMessageInfo requestLineMessageInfo = getRequestLineMessageInfo("200", "OK", "Medium");
		reserveAppointmentResponse.setRequestLineMessageInfo(requestLineMessageInfo);
		reserveAppointmentResponse.setAppointment(appointmentDTO);
		return reserveAppointmentResponse;

	}

	private RequestLineMessageInfo getRequestLineMessageInfo(String completionCode, String message, String sevirity) {
		RequestLineMessageInfo requestLineMessageInfo = new RequestLineMessageInfo();
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setCompletionCode(completionCode);
		messageInfo.setMessage(message);
		messageInfo.setSeverity(sevirity);
		requestLineMessageInfo.setMessageInfo(messageInfo);
		return requestLineMessageInfo;

	}
}
