package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.CricketerAvgBo;

public class CricketerAvgDaoImpl implements CricketerAvgDao{

	public String query="insert into cricketavg values(?,?,?,?,?,?,?)";
	private DataSource dmds;
	
	public CricketerAvgDaoImpl(DataSource dmds) {
		
		this.dmds = dmds;
	}

	public int insert(CricketerAvgBo bo) throws Exception
	{
		Connection con=dmds.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,bo.getName());
		ps.setInt(2,bo.getRunsscored());
		ps.setInt(3,bo.getGotout());
		ps.setInt(4,bo.getRunsgiven());
		ps.setInt(5,bo.getWicketstaken());
		int bat=(int)(bo.getBattingavg());
		int bowl=(int)bo.getBowlingavg();
		ps.setInt(6,bat);
		ps.setInt(7,bowl);
		int count=ps.executeUpdate();
		ps.close();
		con.close();
		return count;
	}
}
