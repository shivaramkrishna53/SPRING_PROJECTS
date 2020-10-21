package com.cb.service;

import com.ipl.external.iiplscorecomp;

public class CricbuzzServiceImpl implements ICricbuzzService {
private iiplscorecomp iiplsc=null;
	@Override
	public String getScore(int matchid) {
		// TODO Auto-generated method stub
		String score=iiplsc.getScore(matchid);
		return score;
	}
	public CricbuzzServiceImpl(iiplscorecomp iiplsc)
	{
		this.iiplsc=iiplsc;
	}

}
