package com.prerak.enrollment.service;

import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.prerak.enrollment.dto.SubjectDto;
import com.prerak.enrollment.model.Subject;
import com.prerak.enrollment.repository.SubjectRepository;

@Service
public class SubjectService {

	private SubjectRepository subjectRepository;
	private ModelMapper modelMapper;

	public SubjectService(SubjectRepository subjectRepository, ModelMapper modelMapper) {
		this.subjectRepository = subjectRepository;
		this.modelMapper = modelMapper;
	}

	public SubjectDto addSubject(SubjectDto subjectDto) throws Exception {
		return mapStudentEntityToDto(subjectRepository.save(mapSubjectDtoToEntity(subjectDto)));
	}

	public SubjectDto updateSubject(String subjectCode, SubjectDto subjectDto) {
		return null;
	}

	public int calculateSubjectCredits(List<String> subjectCodes) throws Exception {
		Iterator<Subject> subjectIterator = getAllSubjects(subjectCodes).iterator();
		int creditEnrolled = 0;
		while (subjectIterator.hasNext()) {
			creditEnrolled += subjectIterator.next().getCredit();
		}
		return creditEnrolled;
	}

	public Iterable<Subject> getAllSubjects(List<String> subjectCodes) throws Exception {
		return subjectRepository.findAllById(subjectCodes);
	}

	private Subject mapSubjectDtoToEntity(SubjectDto studentDto) throws Exception {
		return modelMapper.map(studentDto, Subject.class);
	}

	private SubjectDto mapStudentEntityToDto(Subject student) throws Exception {
		return modelMapper.map(student, SubjectDto.class);
	}

}
