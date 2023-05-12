package com.Project.AppointmentMS.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.AppointmentMS.Entity.Appointment;
import com.Project.AppointmentMS.Payload.AppointmentDTO;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
//	//custom finder methods
	//SELECT *FROM DoctorJOIN appointment ON appointment.doctorid=doctors.id JOIN patientt 
	//On appointment.patientid=patientt.id;
//	
//	@Query("from Appointment JOIN Appointment ON Appointment.doctorid=Doctor.d_id JOIN"
//			+ "Patient ON Appointment.patientid=Patient.p_id")
//	
	
	
//	
	@Query(value="SELECT appointment.appointment_id,\r\n"
			+ "appointment.appoint_date,appointment.slot,\r\n"
			+ "doctors.name as DOCTOR,doctors.email,doctors.specialization_id,\r\n"
			+ "patientt.name as PATIENT, patientt.email,appointment.patientid\r\n"
			+ "FROM doctors  JOIN appointment \r\n"
			
			+ "JOIN patientt \r\n"
			+ "On appointment.patientid=patientt.id  WHERE appointment.patientid=? AND appointment.doctorid=doctors.id",nativeQuery=true)
	List<String> findAppointmentByPatientId(Long patient_id);
	
	
	

	//List<Appointment>  findByPatientid(Long patient_id);
	
	@Query(value="SELECT appointment.appointment_id,\r\n"
			+ "appointment.appoint_date,appointment.slot,\r\n"
			+ "doctors.name as DOCTOR,doctors.email,doctors.specialization_id,\r\n"
			+ "patientt.name as PATIENT, patientt.email,appointment.patientid\r\n"
			+ "FROM doctors  JOIN appointment \r\n"
			
			+ "JOIN patientt \r\n"
			+ "On appointment.patientid=patientt.id  WHERE appointment.doctorid=? AND appointment.doctorid=doctors.id",nativeQuery=true)
	List<String> findAppointmentByDoctorId(Long doctor_id);
	
	
	
	
	@Query(value="select * from appointment where appointment.doctorid=?1 and slot = ?2 and appoint_date = ?3", nativeQuery = true)
    List<Appointment> findApointmentByslot(Long doctorid, String slot, Date date) ;
	
	
	
}
