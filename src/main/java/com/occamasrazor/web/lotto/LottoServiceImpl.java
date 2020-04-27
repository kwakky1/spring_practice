package com.occamasrazor.web.lotto;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Service;

import com.occamasrazor.web.util.LottoResult;

@Service
public class LottoServiceImpl implements LottoService {
	private int[] number;
	private Map<String,Object> map;
	private Random random;
	
	public LottoServiceImpl() {
		random = new Random();
		number = new int[6];
		map = new HashMap<>();
	}


	@Override
	public int[] random() {
		for(int i=0;i<number.length;i++) {
			number[i] = random.nextInt(45)+1;
			for(int j=0;j<i;j++) {
				if(number[i]==number[j]) {
					i--;
				}
			}
			}
		return number;
	}
	

	@Override
	public LottoResult compare(Lotto lotto) {
		LottoResult result =null;
		String[] putLotto = detail(lotto.getUserid()).getLotto().split(",");
		int[] putRandom = random();
		int count=0;
		for(int i =0; i < putRandom.length ; i++) {
			for(int j = 0; j< putLotto.length; j++) {
				if(putRandom[i] == Integer.parseInt(putLotto[j])) {
					count++;
				}
			}
		}
		
		switch(count) {
			case 6: result = LottoResult.FIRST;break;
			case 5: result = LottoResult.SECOND;break;
			case 4: result = LottoResult.THIRD;break;
			default: result = LottoResult.FAIL;break;
		}
		
		
		return result;
	}
	
	@Override
	public void add(Lotto lotto) {
		map.put(lotto.getUserid(), lotto);
	}
	
	@Override
	public int count() {
		return map.size();
	}
	
	@Override
	public Lotto detail(String userid) {
		return (Lotto) map.get(userid);
	}
}
