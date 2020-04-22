package com.occamasrazor.web.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamasrazor.web.member.MemberService;
import com.occamasrazor.web.util.Credit;
import com.occamasrazor.web.util.Messenger;

@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired GradeService gradeService;
	
	@PostMapping("/addition")
	public Messenger add(@RequestBody Grade grade) {
		int current = gradeService.count();
		gradeService.add(grade);
		return (gradeService.count()==(current+1))? Messenger.SUCCESS:Messenger.FAIL;
		
	}
	@PostMapping("/register")
	public Credit confirm(@RequestBody Grade grade) {
		int a = gradeService.average(grade)/10;
		Credit b = null;
		switch(a) {
		case 9: b = Credit.A;
			break;
		case 8: b = Credit.B;
		break;
		case 7: b = Credit.C;
		break;
		case 6: b = Credit.D;
		break;
		case 5: b = Credit.E;
		break;
		case 4: b = Credit.F;
		break;
		default : b = Credit.F;
		break;
		}
		return b;
		
	}
	
}
