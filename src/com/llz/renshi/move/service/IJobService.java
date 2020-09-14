package com.llz.renshi.move.service;

import com.llz.renshi.move.domain.Job;

public interface IJobService {
	//ͨ�����Ʊ�����Ʋ��Ҹ�λ��Ϣ
	public Job queryIdJobsByName(String name);
}
