package com.capgemini.dtoandmapperpractice;

public class StudentMapper {
	
	public static Student createStudent(StudentDTO dto) {
		Student s = new Student();
		s.setName(dto.getName());
		s.setGender(dto.getGender());
		s.setMarks(dto.getMarks());
		s.setCollege(dto.getCollege());
		
		return s; 
		
	}
	
	public static StudentDTO createStudentDTO(Student s) {
		StudentDTO dto = new StudentDTO();
		dto.setName(s.getName());
		dto.setMarks(s.getMarks());
		return dto; 
	}

}
