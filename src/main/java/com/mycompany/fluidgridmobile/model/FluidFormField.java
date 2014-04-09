/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fluidgridmobile.model;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author helge
 */
public class FluidFormField implements Serializable {

    private static final long serialVersionUID = -8023288948145560187L;
    private final Object value;
    private final List<SelectItem> selectItems;
    private Boolean required;
    private String input;
    private String label;

    public FluidFormField(Object value, List<SelectItem> selectItems) {
        this.value = value;
        this.selectItems = selectItems;
    }

    public FluidFormField(Object value, Boolean required, List<SelectItem> selectItems) {
        this.value = value;
        this.selectItems = selectItems;
        this.required = required;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public Object getValue() {
        return value;
    }
    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    @Override
    public String toString() {
        return "FormField{" + "value=" + value + ", required=" + required + '}';
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
