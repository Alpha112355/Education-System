package com.cg.education_system.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.education_system.Exception.ProgressNotFoundExcption;
import com.cg.education_system.Exception.StudentNotFoundExcption;
import com.cg.education_system.Service.ProgressService;
import com.cg.education_system.dto.ProgressDto;
import com.cg.education_system.dto.StudentDto;
import com.cg.education_system.entity.Progress;
import com.cg.education_system.entity.Student;
import com.cg.education_system.repository.ProgressRepository;

@Service
public class ProgressServiceImpl implements ProgressService{
	Log LOGGER = LogFactory.getFactory().getLog(ProgressService.class);
	@Autowired
	
	ProgressRepository ProgressRepo;
	
	@Override
	public List<ProgressDto> getAllProgress() {
		LOGGER.info("ProgressServiceImpl::getAllProgress::Entered");
		List<ProgressDto> progresss = new ArrayList<>();
		
		List<Progress> progressList = ProgressRepo.findAll();
		progressList.stream().forEach(progress -> {
			ProgressDto progressDto = new ProgressDto();
			progressDto.setId(progress.getId());
			progressDto.setComments(progress.getComments());
			progressDto.setScoredMarks(progress.getScoredMarks());
			
			progresss.add(progressDto);
		});
		LOGGER.info("ProgressServiceImpl::getAllProgress::Exited");
		return progresss;
	}

	@Override
	public ProgressDto getProgress(long id) {
		LOGGER.info("ProgressServiceImpl::getProgress::Entered");
		
		Optional<Progress> ProgressOpt = ProgressRepo.findById(id);
		ProgressDto progressDto = new ProgressDto();
		if(ProgressOpt.isPresent()) {
			Progress progress = ProgressOpt.get();
			progressDto.setId(progress.getId());
			//progressDto.setStudent(progress.getStudent());
			progressDto.setScoredMarks(progress.getScoredMarks());
			progressDto.setComments(progress.getComments());
			
		}
		else{
			throw new ProgressNotFoundExcption("Progress with id::"+id+" Not found");
		}
		LOGGER.info("ProgressServiceImpl::getProgress::exited");
		return progressDto;
	}

	@Override
	public ProgressDto saveProgress(ProgressDto progress) {
		LOGGER.info("ProgressServiceImpl::saveProgress::entered");
		Progress progressEntity = new Progress();
		//progressEntity.setId(progress.getId());
		//progressEntity.setStudent(progress.getStudent());
		progressEntity.setScoredMarks(progress.getScoredMarks());
		progressEntity.setComments(progress.getComments());
		ProgressRepo.save(progressEntity);
		progress.setId(progressEntity.getId());
		LOGGER.info("ProgressServiceImpl::saveProgress::exited");
		return progress;
	}

	@Override
	public ProgressDto updateProgress(ProgressDto progress) {
		LOGGER.info("ProgressServiceImpl::updateProgress::entered");
		
		Progress progressEntity = new Progress();
		progressEntity.setId(progress.getId());
		//progressEntity.setStudent(progress.getStudent());
		progressEntity.setScoredMarks(progress.getScoredMarks());
		progressEntity.setComments(progress.getComments());
		ProgressRepo.save(progressEntity);
		
		LOGGER.info("ProgressServiceImpl::updateProgress::exited");
		return progress;
	}

	@Override
	public void deleteProgress(long Id) {
		ProgressRepo.deleteById(Id);
		
	}



}
