package com.occamasrazor.web.grade;

public interface GradeService {
	public void add(Grade grade);
	public Grade[] list();
	public int count();
	public int total(Grade grade);
	public int average(Grade grade);
	public Grade detail(Grade grade);
	public void update(Grade grade);
	public void delete(Grade grade);
	
}
