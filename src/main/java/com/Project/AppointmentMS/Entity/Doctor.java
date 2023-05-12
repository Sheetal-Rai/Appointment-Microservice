package com.Project.AppointmentMS.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	
	
    private long d_id;
	
	
	private String name;
	
	
	private String email;
	
	
	private String password;
	
	
	private String address;
}
