package com.occamasrazor.web.lotto;

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
		System.out.println("하이"+lotto);
		lottoService.putLotto(lotto);
		return Messenger.SUCCESS;
		
	}
	@GetMapping("/comfirm")
	public LottoResult result() {
		System.out.println(lottoService.getLottoResult());
		return lottoService.getLottoResult();
		
	}
}
