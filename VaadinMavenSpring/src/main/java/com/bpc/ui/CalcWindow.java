/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpc.ui;

import com.bpc.services.CalculateServices;
import com.bpc.utils.SpringContextHelper;
import com.vaadin.data.validator.DoubleValidator;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import org.springframework.security.access.AccessDeniedException;

/**
 * @author do_th
 */
public class CalcWindow extends Window implements Button.ClickListener {
    private TextField n1Text;
    private TextField n2Text;
    private Button calcButton;
    private Label labelResult;
    private CalculateServices calculateServices;


    public CalcWindow() {
        this("Calculation Window");
    }

    public CalcWindow(String caption) {
        super(caption);
        n1Text = new TextField("Number 1: ");
        n2Text = new TextField("Number 2: ");
        calcButton = new Button("Add Calculate");
        labelResult = new Label("Result : ");
        n1Text.addValidator(new DoubleValidator("Inter Number Value!"));
        n2Text.addValidator(new DoubleValidator("Inter Number Value!"));
        setSizeFull();
        setPositionX(0);
        setPositionX(0);
        addComponent(n1Text);
        addComponent(n2Text);
        addComponent(calcButton);
        addComponent(labelResult);
        calcButton.addListener(this);
        TableFooterExample tableFooterExample = new TableFooterExample();
        addComponent(tableFooterExample);

        TableMainFeaturesExample tableMainFeaturesExample = new TableMainFeaturesExample();
        addComponent(tableMainFeaturesExample);
        addListener(new Window.CloseListener() {
            // inline close-listener
            public void windowClose(CloseEvent e) {
                n1Text.setValue("");
                n2Text.setValue("");
                labelResult.setValue("Result: ");
                //getParent().removeWindow(this);

            }

        });
    }

    public void buttonClick(ClickEvent event) {
        try {
            Double n1 = new Double((String) n1Text.getValue());
            Double n2 = new Double((String) n2Text.getValue());
            //calculateServices = (CalculateServices)SpringContextHelper.getInstance().getBean("calculateServices");
            Double result = calculateServices.addCalc(n1, n2);
            String str = "Result: " + result.toString();
            labelResult.setValue(str);
        } catch (NumberFormatException ex) {
            labelResult.setValue("Result: ");
            ex.printStackTrace();
        } catch (AccessDeniedException accessDeniedException){
            labelResult.setValue("Exception: "+accessDeniedException.getMessage() );
            accessDeniedException.printStackTrace();
        }
    }

    public CalculateServices getCalculateServices() {
        return calculateServices;
    }

    public void setCalculateServices(CalculateServices calculateServices) {
        this.calculateServices = calculateServices;
    }

    public TextField getN1Text() {
        return n1Text;
    }

    public void setN1Text(TextField n1Text) {
        this.n1Text = n1Text;
    }

    public TextField getN2Text() {
        return n2Text;
    }

    public void setN2Text(TextField n2Text) {
        this.n2Text = n2Text;
    }

    public Label getLabelResult() {
        return labelResult;
    }

    public void setLabelResult(Label labelResult) {
        this.labelResult = labelResult;
    }
}
