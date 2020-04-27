package com.occamasrazor.web.lotto;

import java.util.Map;

import com.occamasrazor.web.util.LottoResult;

public interface LottoService {
	public int[] random();
	public void add(Lotto lotto);
	public int count();
	public Lotto detail(String userid);
	public LottoResult compare(Lotto lotto);
}
