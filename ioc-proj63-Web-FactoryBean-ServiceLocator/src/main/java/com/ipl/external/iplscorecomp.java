package com.ipl.external;

public class iplscorecomp implements iiplscorecomp {

	@Override
	public String getScore(int matchid) {
		if(matchid==101)
			return "csk vs mi"+"csk won by 5 wickets";
		else
			if(matchid==102)
				return "srh vs rcb"+"rcb won by 20runs";
			else
				if(matchid==103)
					return "kkr vs rr"+"rr won by 3 wickets";
				else
					throw new IllegalArgumentException("no such match id");
	}

}
