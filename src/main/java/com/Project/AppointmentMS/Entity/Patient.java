package com.Project.AppointmentMS.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class Patient {
	
	private long p_id;
	
	
	private String name;
	
	private String email;
	

	

	private String password;
	
	
	private String address;
}
