package com.occamasrazor.web.grade;

import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {
	private Grade[] grades;
	private int count;
	public GradeServiceImpl() {
		grades = new Grade[5];
		count =0;
	}
	@Override
	public void add(Grade grade) {
		grades[count]=grade;
		count++;
	}

	@Override
	public Grade[] list() {
		return grades;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public Grade detail(Grade grade) {
		return null;
	}

	@Override
	public void update(Grade grade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Grade grade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int total(Grade grade) {
		int total =0;
		total=Integer.parseInt(grade.getKorean())+Integer.parseInt(grade.getEnglish())+
				Integer.parseInt(grade.getMath())+Integer.parseInt(grade.getJava());
		return total;
	}
	@Override
	public int average(Grade grade) {
		int average =0;
		average = total(grade)/4;
		return average;
	}

}
