package net.edupoll.kr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.repository.FreeboardDao;

@Service
public class FreeboardService {

	@Autowired
	FreeboardDao freeboardDao;
	
	
	
}
