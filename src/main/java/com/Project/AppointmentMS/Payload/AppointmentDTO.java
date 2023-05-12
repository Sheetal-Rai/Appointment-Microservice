package com.Project.AppointmentMS.Payload;


import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AppointmentDTO {
	
private Long appointment_id;
	
@NotEmpty
@NotBlank(message = "patient id should not be blank")
	private Long patientid;
	
//
//@NotEmpty
//@NotBlank(message = "patient name should not be blank")
//	private String patientname;


@NotEmpty
@NotBlank(message = "doctor id  should not be blank")
	private Long doctorid;

//@NotEmpty
//@NotBlank(message = "patient id should not be blank")
//	private String doctorname;
	
@NotEmpty
@NotBlank(message = "date should not be blank")
	private Date appoint_date;
	
@NotEmpty
@NotBlank(message = "slot should not be blank")
	private String slot;

}
