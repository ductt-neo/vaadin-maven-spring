package com.bpc.dao;

import java.util.List;

import com.bpc.model.Factor;

public class FactorDaoImpl extends AbstractHibernateDAOImpl<Factor, Long> implements FactorDao {

   protected Class<Factor> getDomainClass() {
      return Factor.class;
   }

   public List<Factor> findAll() {
      return getList();
   }

   public Factor findByName(String name) {
//      List<?> factors = getHibernateTemplate().findByNamedQueryAndNamedParam(Factor.FIND_BYNAME, "name", name);
      return null;
   }

}
