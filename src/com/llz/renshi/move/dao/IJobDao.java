package com.llz.renshi.move.dao;

import com.llz.renshi.move.domain.Job;

public interface IJobDao {
	//ͨ�����Ʊ�����Ʋ��Ҹ�λ��Ϣ
	public Job queryIdJobsByName(String name);
}
