package com.xworkz.cm.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.cm.dto.CmDTO;

public interface CmService {

	Set<ConstraintViolation<CmDTO>> validateAndSave(CmDTO dto);

	default CmDTO userSignIn(String userId, String password) {
		return null;
	}

	default List<CmDTO> findAll() {
		return Collections.emptyList();
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long mobile) {
		return null;
	}

	default Long findByUser(String user) {
		return null;
	}

}
