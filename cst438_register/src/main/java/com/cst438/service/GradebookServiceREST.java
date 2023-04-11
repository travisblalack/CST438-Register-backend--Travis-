package com.cst438.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.cst438.domain.EnrollmentDTO;


public class GradebookServiceREST extends GradebookService {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${gradebook.url}")
	String gradebook_url;
	
	public GradebookServiceREST() {
		System.out.println("REST grade book service");
	}

	@Override
	public void enrollStudent(String student_email, String student_name, int course_id) {
		
		EnrollmentDTO e = new EnrollmentDTO();
		e.course_id=course_id;
		e.studentEmail=student_email;
		e.studentName=student_email;
		
		System.out.println("Post to gradebook"+e);
		EnrollmentDTO res = restTemplate.postForObject(gradebook_url+"/enrollment",e,EnrollmentDTO.class);
		System.out.println("Response from gradebook"+res);
		
	}

}
