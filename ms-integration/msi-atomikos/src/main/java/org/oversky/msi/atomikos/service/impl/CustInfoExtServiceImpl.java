package org.oversky.msi.atomikos.service.impl;

import org.oversky.dreamland.dao.cust.CustInfoExtDao;
import org.oversky.dreamland.entity.cust.CustInfoExt;
import org.oversky.msi.atomikos.service.CustInfoExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustInfoExtServiceImpl implements CustInfoExtService {

	@Autowired
	private CustInfoExtDao custExtDao;
	
	@Override
	@Transactional
	public void save(CustInfoExt cust) {
		// TODO Auto-generated method stub
		custExtDao.insert(cust);
		int i = 1/0;
		System.out.println(i);
	}

	@Override
	@Transactional
	public void delete(Long custNo) {
		// TODO Auto-generated method stub
		custExtDao.deleteById(custNo);
	}

}
