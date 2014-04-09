/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fluidgridmobile.model;

/**
 *
 * @author helge
 */
public class UserAttribute {

    private String attribute;
    private String value;
    private Boolean mandatory;
    private String regexp;

    public UserAttribute() {
    }

    public UserAttribute(String attribute, String value, Boolean mandatory, String regexp) {
        this.attribute = attribute;
        this.value = value;
        this.mandatory = mandatory;
        this.regexp = regexp;
    }

    public UserAttribute(String attribute, Boolean mandatory, String regexp) {
        this.attribute = attribute;
        this.mandatory = mandatory;
        this.regexp = regexp;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

}
