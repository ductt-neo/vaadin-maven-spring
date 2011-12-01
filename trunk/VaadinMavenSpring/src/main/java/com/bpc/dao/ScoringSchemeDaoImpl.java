package com.bpc.dao;

import java.util.List;

import com.bpc.model.ScoringScheme;

public class ScoringSchemeDaoImpl extends AbstractHibernateDAOImpl<ScoringScheme, Long> implements ScoringSchemeDao {

   public List<ScoringScheme> findAll() {
      return getList();
   }

   protected Class<ScoringScheme> getDomainClass() {
      return ScoringScheme.class;
   }

}
