package com.example.demo.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PracticeAPIRepository;
import com.example.demo.data.AddEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class PracticeAPIService {
	private final PracticeAPIRepository practiceAPIRepository;

	@Autowired
	public PracticeAPIService(PracticeAPIRepository practiceAPIRepository) {
		this.practiceAPIRepository = practiceAPIRepository;
	}

	public ArrayList<String> ser() throws JsonMappingException, JsonProcessingException {

		AddEntity addEntity = new AddEntity();

		addEntity = practiceAPIRepository.rep();

		int size = addEntity.getData().size();

		try {
			ArrayList<String> list = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				list.add(addEntity.getData().get(i).getName() + "、" + addEntity.getData().get(i).getNote() + "、"
						+ addEntity.getData().get(i).getAge().toString() + "、"
						+ addEntity.getData().get(i).getRegisterDate());
			}
			return list;
		} catch (Exception e) {
			throw e;
		}
	}
}