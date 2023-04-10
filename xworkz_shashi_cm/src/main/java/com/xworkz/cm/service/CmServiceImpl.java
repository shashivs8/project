package com.xworkz.cm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.cm.dto.CmDTO;
import com.xworkz.cm.entity.CmEntity;
import com.xworkz.cm.repository.CmRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CmServiceImpl implements CmService {

	@Autowired
	public CmRepository cmRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private Set<ConstraintViolation<CmDTO>> validate(CmDTO userDto) {
		ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validationFactory.getValidator();
		Set<ConstraintViolation<CmDTO>> vailation = validator.validate(userDto);
		return vailation;
	}

	public CmServiceImpl() {
		log.info("" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<CmDTO>> validateAndSave(CmDTO userDTO) {
		/*
		 * Long emailCount = this.cmRepository.findByEmail(userDTO.getEmail()); Long
		 * userCount = this.cmRepository.findByUser(userDTO.getUserId()); Long
		 * mobileCount = this.cmRepository.findByMobile(userDTO.getMobile());
		 * log.error("emailCount-" + emailCount); log.error("userCount-" + userCount);
		 * log.error("mobileCount-" + mobileCount);
		 */

		Set<ConstraintViolation<CmDTO>> violations = validate(userDTO);
		if (violations != null && !violations.isEmpty()) {
			log.info("there is Violation in dto");
			return violations;
		}
		if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			return null;
		} else {
			log.info("No Violations procceding to save");
			CmEntity entity = new CmEntity();
			entity.setCreatedBy(userDTO.getUserId());
			entity.setCreatedDate(LocalDateTime.now());
			entity.setMobile(userDTO.getMobile());
			entity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			entity.setUserId(userDTO.getUserId());
			entity.setEmail(userDTO.getEmail());
			boolean saved = this.cmRepository.save(entity);

		}

		return Collections.emptySet();
	}

	@Override
	public CmDTO userSignIn(String userId, String password) {
		CmEntity entity = this.cmRepository.userSignIn(userId, password);
		CmDTO dto = new CmDTO();
		dto.setUserId(entity.getUserId());
		dto.setPassword(entity.getPassword());
		if (dto.getUserId().equals(userId) && dto.getPassword().equals(password)) {
			return dto;
		}
		return null;
	}

	@Override
	public List<CmDTO> findAll() {
		List<CmEntity> userEntity = this.cmRepository.findAll();
		List<CmDTO> lists = new ArrayList<CmDTO>();
		for (CmEntity entity : userEntity) {
			CmDTO dto = new CmDTO();
			BeanUtils.copyProperties(entity, dto);
			lists.add(dto);

		}
		return lists;
	}

	@Override
	public Long findByEmail(String email) {
		Long emailcount = this.cmRepository.findByEmail(email);
		log.error("Find  by Email");
		return emailcount;
	}

	@Override
	public Long findByMobile(Long mobile) {
		Long mobilecount = this.cmRepository.findByMobile(mobile);
		return mobilecount;
	}

	@Override
	public Long findByUser(String user) {
		Long userCount = this.cmRepository.findByUser(user);
		return userCount;
	}

}
