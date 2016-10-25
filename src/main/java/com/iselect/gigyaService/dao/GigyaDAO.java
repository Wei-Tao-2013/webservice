package com.iselect.gigyaService.dao;

import java.util.List;

import com.iselect.gigyaService.model.Gigya;


public interface GigyaDAO {
    
    public Gigya merge(Gigya gigya);
    public List<Gigya> listInfo();   
    public Gigya getInfo(String socialUUID,String vertical); 
}


