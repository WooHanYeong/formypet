package com.formypet.jpa.adopt.service;

import java.util.List;
import java.util.Optional;

import com.formypet.jpa.adopt.dto.AdoptDto;
import com.formypet.jpa.adopt.entity.Adopt;

public interface AdoptService {

	
	//입양등록(유저)
	public Adopt insert(Adopt adopt);
	
	//입양리스트(관리자)
	List<Adopt> findAllAdoptList();
	
	//입양취소
	void deleteAdopt(Long id);
	
	//status수정
	AdoptDto updateAdoptStatus(AdoptDto adoptDto)throws Exception;
	
	//한개찾기
	public Optional<Adopt> findById(Long id);
	
	
}
	
