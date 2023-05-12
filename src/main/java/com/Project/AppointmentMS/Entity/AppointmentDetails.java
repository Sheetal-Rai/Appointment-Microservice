package com.Project.AppointmentMS.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AppointmentDetails {
	
	
	@Override
	public String toString() {
		return "AppointmentDetails [a_id=" + a_id + ", date=" + date + ", slot=" + slot + ", doc_name=" + doc_name
				+ ", doc_email=" + doc_email + ", doc_specialId=" + doc_specialId + ", patient_name=" + patient_name
				+ ", patient_email=" + patient_email + ", patientid=" + patientid + "]";
	}
	private String a_id;
	
	private String date;
	private String slot;
	private String doc_name;
	private String doc_email;
	private String doc_specialId;
	private String patient_name;
	private String patient_email;
	private String patientid;
	
	
	public AppointmentDetails(String a_id, String date, String slot, String doc_name, String doc_email,
			String doc_specialId, String patient_name, String patient_email, String patientid) {
		super();
		this.a_id = a_id;
		this.date = date;
		this.slot = slot;
		this.doc_name = doc_name;
		this.doc_email = doc_email;
		this.doc_specialId = doc_specialId;
		this.patient_name = patient_name;
		this.patient_email = patient_email;
		this.patientid = patientid;
	}


	
	

}
