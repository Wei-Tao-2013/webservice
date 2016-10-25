package com.iselect.gigyaService.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iselect.gigyaService.dao.GigyaDAO;
import com.iselect.gigyaService.model.Gigya;

@Repository
@Transactional
public class GigyaDAOImpl implements GigyaDAO {

	/** Gets the logger. */
	private Logger logger = LoggerFactory.getLogger(GigyaDAOImpl.class);

	/** For persistence. */
	@PersistenceContext
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Gigya merge(Gigya gigya) {
		return em.merge(gigya);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Gigya> listInfo() {
		return em.createQuery("select o from Gigya o").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Gigya getInfo(String socialUUID,String vertical) {	
		ArrayList<Gigya> arrLst=  (ArrayList<Gigya>) em.createQuery("select g from Gigya g where g.socialUUID = ? and LOWER(g.vertical) = ? ")
				.setParameter(1, socialUUID)
				.setParameter(2, vertical.toLowerCase())
				.getResultList();	
		
		if(arrLst.size()>0){
			return (Gigya)arrLst.get(0);
		}else{
			return null;
		}
				
		
	}

	
}
