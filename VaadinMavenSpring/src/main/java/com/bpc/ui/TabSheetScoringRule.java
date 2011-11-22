package com.bpc.ui;

import com.bpc.utils.ScoringRuleController;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;


/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/21/11
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class TabSheetScoringRule extends VerticalLayout {

    private ScoringRuleController scoringRuleController;
    private RuleCaseTable ruleCaseTable;
    private MappingRuleTable mappingRuleTable;
    private TabSheet t;

    public void setScoringRuleController(ScoringRuleController scoringRuleController) {
        this.scoringRuleController = scoringRuleController;
    }

    public TabSheetScoringRule(RuleCaseTable ruleCaseTable, MappingRuleTable mappingRuleTable) {
        // Tab 1 content
        this.ruleCaseTable = ruleCaseTable;
        this.mappingRuleTable = mappingRuleTable;
        //this.ruleCaseTable.setMargin(true);

        t = new TabSheet();
        t.setHeight("260px");
        t.setWidth("100%");

        t.addTab(this.ruleCaseTable, "Rule Cases");
        t.addTab(this.mappingRuleTable, "Mapping Rules");

        t.addComponent(this.ruleCaseTable);
        t.addComponent(this.mappingRuleTable);
        addComponent(t);
    }

    public void setRuleCaseTable(RuleCaseTable ruleCaseTable) {
        this.ruleCaseTable = ruleCaseTable;
    }

    public RuleCaseTable getRuleCaseTable() {
        return ruleCaseTable;
    }

    public MappingRuleTable getMappingRuleTable() {
        return mappingRuleTable;
    }

    public void setMappingRuleTable(MappingRuleTable mappingRuleTable) {
        this.mappingRuleTable = mappingRuleTable;
    }
}
