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
    private TabSheet t;

    public void setScoringRuleController(ScoringRuleController scoringRuleController) {
        this.scoringRuleController = scoringRuleController;
    }

    public TabSheetScoringRule(RuleCaseTable ruleCaseTable) {
        // Tab 1 content
        this.ruleCaseTable =  ruleCaseTable;
        this.ruleCaseTable.setMargin(true);

        // Tab 2 content
        VerticalLayout l2 = new VerticalLayout();
        l2.setMargin(true);
        l2.addComponent(new Label("There are mapping cases."));
        // Tab 3 content


        t = new TabSheet();
        t.setHeight("250px");
        t.setWidth("100%");

        t.addTab(this.ruleCaseTable, "Rule Cases");
        t.addTab(l2, "Mapping Rules");
       // t.addTab(l3, "Issues");
        t.addComponent(this.ruleCaseTable);
        addComponent(t);
    }

    public void setRuleCaseTable(RuleCaseTable ruleCaseTable) {
        this.ruleCaseTable = ruleCaseTable;
    }

    public RuleCaseTable getRuleCaseTable() {
        return ruleCaseTable;
    }
}
