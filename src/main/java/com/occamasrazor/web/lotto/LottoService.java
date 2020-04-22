package com.occamasrazor.web.lotto;

import com.occamasrazor.web.util.LottoResult;

public interface LottoService {
	public int[] random();
	public void add(Lotto lotto);
	public void compare();
	public void putLotto(Lotto lotto);
	public LottoResult getLottoResult();
}
