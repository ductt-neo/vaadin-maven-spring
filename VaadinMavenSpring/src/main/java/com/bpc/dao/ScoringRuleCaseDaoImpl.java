package com.bpc.dao;

import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA. User: do_th Date: 11/21/11 Time: 2:25 PM To change
 * this template use File | Settings | File Templates.
 */
public class ScoringRuleCaseDaoImpl extends
		AbstractHibernateDAOImpl<ScoringRuleCase, Integer> implements
		ScoringRuleCaseDao {
	@Override
	protected Class<ScoringRuleCase> getDomainClass() {
		return ScoringRuleCase.class;
	}

	@SuppressWarnings("unchecked")
	public List<ScoringRuleCase> getRuleCaseList(ScoringRule scoringRule) {
		List<ScoringRuleCase> ruleCaseList = getHibernateTemplate()
				.findByNamedParam(
						"SELECT s FROM ScoringRuleCase s WHERE s.rule = :scoringRule",
						"scoringRule", scoringRule);
		return ruleCaseList;
	}
}
