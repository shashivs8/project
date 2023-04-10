package com.xworkz.cm.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.cm.entity.CmEntity;

public interface CmRepository {

	boolean save(CmEntity cmEntity);

	default List<CmEntity> findAll() {
		return Collections.emptyList();
	}

	default CmEntity userSignIn(String userId, String password) {
		return null;
	}

	default Long findByUser(String user) {
		return null;
	}

	default Long findByEmail(String email) {
		return null;
	}

	default Long findByMobile(Long number) {
		return null;
	}

}
