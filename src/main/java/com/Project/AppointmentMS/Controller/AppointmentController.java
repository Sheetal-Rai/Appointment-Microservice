package com.Project.AppointmentMS.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.Project.AppointmentMS.Entity.Appointment;
import com.Project.AppointmentMS.Entity.AppointmentDetails;
import com.Project.AppointmentMS.Payload.AppointmentDTO;
import com.Project.AppointmentMS.Payload.apiResponse;
import com.Project.AppointmentMS.Service.AppointmentService;


@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/created")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO appointment ){
    List<Appointment> value = this.appointmentService.presentCheck(appointment.getDoctorid(), appointment.getSlot(), appointment.getAppoint_date()) ;
        
        System.out.println(value);
        
        if(value.isEmpty()) {
            
            System.out.println("there is no duplicate value");
            
            AppointmentDTO createApointmentDto = this.appointmentService.create(appointment) ;
            
            return new ResponseEntity<>(createApointmentDto, HttpStatus.CREATED) ;
        }else {
            System.out.println("duplicate value present");
            return null ;
        }
		
	}
	
	
	
	
	@PutMapping("/{a_id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody
			AppointmentDTO appointment, 
			@PathVariable Long a_id ){
List<Appointment> value = this.appointmentService.presentCheck(appointment.getDoctorid(), appointment.getSlot(), appointment.getAppoint_date()) ;
        
        System.out.println(value);
        
        if(value.isEmpty()) {
            
            System.out.println("there is not a duplicate value over here");
            
            AppointmentDTO updatedDTO=this.appointmentService.updateAppointment(appointment, a_id);
            return new ResponseEntity<AppointmentDTO>(updatedDTO,HttpStatus.OK);
        }else {
            System.out.println("duplicate value present");
            return null ;
        }
		
	}
		
		
	
	
	
	
	
	
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<List<AppointmentDTO>> getAppointments(){
		return ResponseEntity.ok(appointmentService.getAppointments());}
	
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id){
		return ResponseEntity.ok(this.appointmentService.getAppointmentById(id));
	}
	
	
	
   @GetMapping("/patient/{p_id}")
   @CrossOrigin(origins = "http://localhost:3000")
	public List<AppointmentDetails> getRatingByPatient(@PathVariable Long p_id){
	   
	   List<String> A_details=appointmentService.getAppointmentByPatient(p_id);
		
	   List<AppointmentDetails> appointmentDetails= new ArrayList<AppointmentDetails>();
	   
	   
	   for(String s:A_details)
	   {
		   
		   String[] data= s.split(",");
		   
		   appointmentDetails.add(new AppointmentDetails(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8]));
	   }
		return appointmentDetails;
	}

   
//	
//	
	@GetMapping("/doctors/{dId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<AppointmentDetails> getRatingByDOctor(@PathVariable Long dId){
		   List<String> A_details=appointmentService.getAppointmentByDoctor(dId);
			
		   List<AppointmentDetails> appointmentDetails= new ArrayList<AppointmentDetails>();
		   
		   
		   for(String s:A_details)
		   {
			   
			   String[] data= s.split(",");
			   
			   appointmentDetails.add(new AppointmentDetails(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8]));
		   }
			return appointmentDetails;
		}
	
	
	
	
	@DeleteMapping("/{de_id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<apiResponse> deleteAppointment(
			@PathVariable Long de_id){
		this.appointmentService.deleteAppointment(de_id);
		return new ResponseEntity<apiResponse>
		(new apiResponse("Appointment is successfully Deleted"
				,true),HttpStatus.OK);
		
	}
	
	
}
