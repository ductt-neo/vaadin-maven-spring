package com.bpc.services;

import com.bpc.model.MappingRule;
import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;
import com.bpc.model.ScoringUser;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ScoringUserAuthorityServices {
    public ScoringUser getUserAuthority(String userName);

}
