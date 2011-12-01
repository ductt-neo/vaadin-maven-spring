package com.bpc.dao;

import java.util.List;

import com.bpc.model.ScoringScheme;

public interface ScoringSchemeDao extends AbstractDAO<ScoringScheme, Long> {
   List<ScoringScheme> findAll();

}
