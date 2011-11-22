/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpc.example;

import com.bpc.ui.CalcWindow;
import com.bpc.ui.ScoringRuleTable;
import com.bpc.ui.TabSheetScoringRule;
import com.bpc.ui.UserTableExample;
import com.bpc.utils.SpringContextHelper;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 *
 * @author do_th
 */
//@Configurable(preConstruction = true)
public class SpringHelloWorld extends com.vaadin.Application implements Button.ClickListener {

    //@Autowired
    //private CalculateServices bean;
    private CalcWindow calcdWin;
    private Window mainWindow;
    private ScoringRuleTable scoringRuleTable;


    //@Override
    public void init() {
        SpringContextHelper.getInstance(this);
        mainWindow = new Window("MyApplication");
        Label label = new Label("Hello Vaadin user");
        //mainWindow.addComponent(label);
        setMainWindow(mainWindow);
        Button button = new Button("Add Calculation Window");
        button.addListener(this);
        mainWindow.addComponent(button);
        //TreeTableBasicExample treeTableBasicExample = new TreeTableBasicExample();
        //UserTableExample userTableExample = new UserTableExample();
        //mainWindow.addComponent(treeTableBasicExample);
        mainWindow.addComponent(scoringRuleTable);
        //mainWindow.addComponent(tabSheetScoringRule);
        //calcdWin = new CalcWindow("Child Window");

    }

    public void buttonClick(ClickEvent event) {
        if (calcdWin.getParent() != null) {
            // window is already showing
            mainWindow.removeWindow(calcdWin);

        } else {
            mainWindow.addWindow(calcdWin);

        }
    }

    public void setScoringRuleTable(ScoringRuleTable scoringRuleTable) {
        this.scoringRuleTable = scoringRuleTable;
    }

    public void setCalcdWin(CalcWindow calcdWin) {
        this.calcdWin = calcdWin;
    }


}