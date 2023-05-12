package com.Project.AppointmentMS.Entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="appointment")

public class Appointment {
	
	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", patientid=" + patientid + ", doctorid=" + doctorid
				+ ", appoint_date=" + appoint_date + ", slot=" + slot + "]";
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appointment_id;
	
 
	private Long patientid;
	
	private Long doctorid;

	
	private Date appoint_date;
	
	
	private String slot;
	

	

}

