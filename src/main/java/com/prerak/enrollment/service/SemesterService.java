
package com.prerak.enrollment.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.prerak.enrollment.dto.SemesterDto;
import com.prerak.enrollment.model.Semester;
import com.prerak.enrollment.model.SemesterId;
import com.prerak.enrollment.repository.SemesterRepository;

@Service
public class SemesterService {

	private SemesterRepository semesterRepository;
	private ModelMapper modelMapper;

	public SemesterService(SemesterRepository semesterRepository, ModelMapper modelMapper) {
		this.semesterRepository = semesterRepository;
		this.modelMapper = modelMapper;
	}

	public SemesterDto addSemester(SemesterDto semesterDto) throws Exception {
		return mapSemesterEntityToDto(semesterRepository.save(mapSemesterDtoToEntity(semesterDto)));
	}

	private Semester mapSemesterDtoToEntity(SemesterDto semesterDto) throws Exception {
		SemesterId semesterId = modelMapper.map(semesterDto, SemesterId.class);
		Semester semester = new Semester();
		semester.setSemesterId(semesterId);
		return semester;
	}

	private SemesterDto mapSemesterEntityToDto(Semester semester) throws Exception {
		return modelMapper.map(semester.getSemesterId(), SemesterDto.class);
	}

}
