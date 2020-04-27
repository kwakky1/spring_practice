package com.occamasrazor.web.lotto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamasrazor.web.util.LottoResult;
import com.occamasrazor.web.util.Messenger;
@RestController
@RequestMapping("/lotto")
public class LottoController {
	@Autowired
	LottoService lottoService;
	
	@PostMapping("/buy")
	public Messenger put(@RequestBody Lotto lotto) {
		
		return Messenger.SUCCESS;
		
	}
	@GetMapping("/comfirm")
	public Map<String,Object> result(@RequestBody Lotto lotto) {
		Map<String,Object> returnMap = new HashMap<>();
		LottoResult resultLotto = lottoService.compare(lotto);
		return returnMap;
		
	}
}
