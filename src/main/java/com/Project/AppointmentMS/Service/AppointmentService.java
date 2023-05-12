package com.Project.AppointmentMS.Service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.Project.AppointmentMS.Entity.Appointment;
import com.Project.AppointmentMS.Payload.AppointmentDTO;

public interface AppointmentService {

	
	//create 
	
		AppointmentDTO create(AppointmentDTO appointmentDTO );
		
		
		
		//getallappointments
		
		
		List<AppointmentDTO> getAppointments();
		
		
		//get all by patientid
	
		List<String>  getAppointmentByPatient(Long p_id);
		
		//List<Appointment>  getAppointmentByPatient(Long p_id);
		
		

    	List<String> getAppointmentByDoctor(Long d_id);

   	
   		AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO ,Long id);
   		AppointmentDTO getAppointmentById(Long id);

   			
		void deleteAppointment(Long id);
		
		List<Appointment> presentCheck(Long doctorid, String slot, Date date) ;



	
	
}
