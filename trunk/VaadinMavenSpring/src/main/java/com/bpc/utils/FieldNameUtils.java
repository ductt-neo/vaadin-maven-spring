package com.bpc.utils;

import com.bpc.model.MappingRule;
import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;
import com.bpc.model.ScoringUser;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/22/11
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public final class FieldNameUtils {
     public static String[] scoringRuleFieldName = null;
    public static String[] ruleCaseFieldName = null;
    public static String[] mappingRuleFieldName = null;
    public static String[] scoringUserFieldName = null;


    static {
        scoringRuleFieldName = ClassFieldNameUtils.getFieldNames(ScoringRule.class);
        ruleCaseFieldName = ClassFieldNameUtils.getFieldNames(ScoringRuleCase.class);
        mappingRuleFieldName = ClassFieldNameUtils.getFieldNames(MappingRule.class);
       scoringUserFieldName = ClassFieldNameUtils.getFieldNames(ScoringUser.class);
    }

}
