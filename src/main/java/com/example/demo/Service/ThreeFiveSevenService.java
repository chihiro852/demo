package com.example.demo.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ThreeFiveSevenService {
	public ArrayList<String> doList(String str) {
		try {
			int n = Integer.parseInt(str);
			ArrayList<String> list = new ArrayList<>();

			for (int i = 1; i < n + 1; i++) {
				if (i % 7 == 0 && i % 5 == 0 && i % 3 == 0) {
					list.add("ThreeFiveSeven");
				} else if (i % 7 == 0 && i % 5 == 0) {
					list.add("FiveSeven");
				} else if (i % 7 == 0 && i % 3 == 0) {
					list.add("ThreeSeven");
				} else if (i % 5 == 0 && i % 3 == 0) {
					list.add("ThreeFive");
				} else if (i % 7 == 0) {
					list.add("Seven");
				} else if (i % 5 == 0) {
					list.add("Five");
				} else if (i % 3 == 0) {
					list.add("Three");
				} else {
					list.add(String.valueOf(i));
				}
			}
			return list;
		} catch (Exception e) {
			throw e;
		}
	}
}