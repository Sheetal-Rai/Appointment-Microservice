package com.Project.AppointmentMS;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;

@SpringBootTest
class AppointmentMsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Test
	@Order(1)
	public void testBookAppointment() {
		
		String jsonBody= "{\"patientid\":\"1\", \"doctorid\":\"2\", \"appoint_date\":\"2023-02-09\", \"slot\":\"10:00am\"}";
		String response=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonBody)
				.when()
				.post("http://localhost:8888/api/appointment/created")
				.then()
				.assertThat().statusCode(201)
				.extract().response().asString();
			
	}
	
	
	
	@Test
	@Order(2)
	public void testUpdateAppointment() {
		
		String jsonBody= "{\"patientid\":\"1\", \"doctorid\":\"1\", \"appoint_date\":\"2023-03-08\", \"slot\":\"12:00am\"}";
		String response=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonBody)
				.when()
				.put("http://localhost:8888/api/appointment/136")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
			
		
	}
	
	@Test
	@Order(2)

		public void testGetAllAppointments() {
				String response=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
			.when()
				.get("http://localhost:8888/api/appointment/")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
			
		
			}
	
	@Test
	@Order(3)
	public void testGetAppointmentByPatient() {
		String response=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
			.when()
				.get("http://localhost:8888/api/appointment/patient/1")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
			
	}
	
	@Test
	@Order(4)
	public void testGetAllAppointmentByDoctor() {
		
			String response=given()
			.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.when()
			.get("http://localhost:8888/api/appointment/doctors/3")
			.then()
			.assertThat().statusCode(200)
			.extract().response().asString();
		
	}
	@Test
	@Order(5)
	public void testGetSingleAppointment() {
		String response=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
			.when()
				.get("http://localhost:8888/api/appointment/125")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
		
	}
	
	@Test
	@Order(6)
	public void testDeleteAppointment() {
		String response=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
			.when()
				.delete("http://localhost:8888/api/appointment/135")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
		
	}
}
