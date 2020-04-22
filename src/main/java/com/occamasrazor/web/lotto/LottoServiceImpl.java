package com.occamasrazor.web.lotto;
import java.util.Random;
import org.springframework.stereotype.Service;

import com.occamasrazor.web.util.LottoResult;

@Service
public class LottoServiceImpl implements LottoService {
	private Lotto lotto;
	private int[] number;
	private LottoResult result;
	private int count;
	private Random random;
	
	public LottoServiceImpl() {
		result = null;
		lotto = new Lotto();
		count =0;
		random = new Random();
		number = new int[6];
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
	public void compare() {
		LottoResult result =null;
		String[] putLotto = lotto.getLotto().split(",");
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
		
		System.out.println("result " + result);
		
		this.result = result;
	}
	
	public LottoResult getLottoResult() {
		return result;
	}
		
		/*
		int a[] = random();
		for(int k=0;k<count;k++) {
			String[] lotto = lottos[k].getLotto().split(",");
			for(int i =0; i < a.length ; i++) {
				for(int j = 0; j< lotto.length; j++) {
					if(a[i] == Integer.parseInt(lotto[j])) {
						count++;
					}
				}
			}
		}
		
		
		
		
		
		switch(count) {
		case 1:
			break;
		}
		return compare;
	}
	*/


	@Override
	public void add(Lotto lotto) {
		
	}


	@Override
	public void putLotto(Lotto lotto) {
		this.lotto = lotto;
		System.out.println("시작");
		compare();
	}

	
}
