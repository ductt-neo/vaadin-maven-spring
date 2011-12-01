package com.bpc.dao;

import java.util.List;

import com.bpc.model.Factor;

public interface FactorDao extends AbstractDAO<Factor, Long> {
   public List<Factor> findAll();

   public Factor findByName(String name);
}
