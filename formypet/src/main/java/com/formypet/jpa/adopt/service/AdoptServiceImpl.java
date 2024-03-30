package com.formypet.jpa.adopt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formypet.jpa.adopt.dto.AdoptDto;
import com.formypet.jpa.adopt.entity.Adopt;
import com.formypet.jpa.adopt.repository.AdoptRepository;
import com.formypet.jpa.user.entity.User;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class AdoptServiceImpl implements AdoptService{
	
	@Autowired
	private AdoptRepository adoptRepository;

	//입양등록
	@Override
	public Adopt insert(Adopt adopt) {
		return adoptRepository.save(adopt);
	}
	
	//입양리스트
	@Override
	public List<Adopt> findAllAdoptList() {
		return adoptRepository.findAll();
	}

	//입양취소
	@Override
	public void deleteAdopt(Long id) {
		adoptRepository.deleteById(id);
	}

	//입양상태변경
	@Override
	public AdoptDto updateAdoptStatus(AdoptDto adoptDto) throws Exception {
		Adopt adopt = adoptRepository.findByUserId(adoptDto.getId());
		
		adopt.setAdoptStatus(adoptDto.getAdoptStatus());
		
		Adopt updateAdopt = adoptRepository.save(adopt);
		
		return AdoptDto.toDto(updateAdopt);
	}

	@Override
	public Optional<Adopt> findById(Long id) {
		return adoptRepository.findById(id);
	}

	@Override
	public Adopt findByUserId(Long id) {
		return adoptRepository.findByUserId(id);
	}

}
