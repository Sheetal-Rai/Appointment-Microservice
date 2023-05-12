package com.Project.AppointmentMS.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Project.AppointmentMS.Entity.Appointment;
import com.Project.AppointmentMS.Payload.AppointmentDTO;
import com.Project.AppointmentMS.Repository.AppointmentRepository;
import com.Project.AppointmentMS.Service.AppointmentService;



@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AppointmentDTO create(AppointmentDTO appointmentDTO) {
		Appointment appointment=this.modelMapper.map(appointmentDTO,Appointment.class);
		Appointment savedAppointment=this.appointmentRepository.save(appointment);
		return this.modelMapper.map(savedAppointment, AppointmentDTO.class);
	}
	

	@Override
	
	public List<AppointmentDTO> getAppointments() {
		List<Appointment> aps=this.appointmentRepository.findAll();
	    List<AppointmentDTO> apsDTOs=aps.stream().map((ap)->this.modelMapper
	    		.map(ap,AppointmentDTO.class))
	    		.collect(Collectors.toList());
	    
		return apsDTOs;
	}

	@Override
	public List<String>  getAppointmentByPatient(Long p_id) {
		// TODO Auto-generated method stub
		 return appointmentRepository.findAppointmentByPatientId(p_id);
	}


	
	@Override
	public List<String> getAppointmentByDoctor(Long d_id) {
		return appointmentRepository.findAppointmentByDoctorId(d_id);
	}
	
	
//
	@Override
	public AppointmentDTO updateAppointment(AppointmentDTO appDTO, Long id) {
    Appointment spp=this.appointmentRepository.findById(id).get();
    spp.setDoctorid(appDTO.getDoctorid());
    spp.setPatientid(appDTO.getPatientid());
    spp.setSlot(appDTO.getSlot());
    Appointment updatedAppointment=this.appointmentRepository.save(spp);
	return this.modelMapper.map(updatedAppointment, AppointmentDTO.class);

	}
	
	
	@Override
	public void deleteAppointment(Long id) {
		Appointment app=this.appointmentRepository.findById(id).get();
		this.appointmentRepository.delete(app);
		
	}

	@Override
	public AppointmentDTO getAppointmentById( Long id) {
		
		Appointment appointment=this.appointmentRepository.findById(id).get();
		
		return this.modelMapper.map(appointment, AppointmentDTO.class);
	}

	@Override
	public List<Appointment> presentCheck(Long doctorid, String slot, Date date) {
			List<Appointment> value = this.appointmentRepository.findApointmentByslot(doctorid, slot, date) ;
        
        return value;
	}

	
	

	


}
