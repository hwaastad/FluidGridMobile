/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fluidgridmobile.controller;

import com.mycompany.fluidgridmobile.model.FluidFormField;
import com.mycompany.fluidgridmobile.model.UserAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;
import org.primefaces.extensions.model.fluidgrid.FluidGridItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author helge
 */
@Named
@ViewScoped
public class RegisterController implements Serializable {

    private static final long serialVersionUID = -5446594424265253118L;
    private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);
    private List<FluidGridItem> gridItems;
    private DynaFormModel model;
    private String switchUrl;
    private String uuid;
    private String statusCode;

    @PostConstruct
    public void init() {
        model = new DynaFormModel();
    }

    public void initFeedBack() {
        String s = String.format("StatusCode: %s switchUrl: %s uuid: %s", statusCode, switchUrl, uuid);
        Messages.addGlobalWarn(s);
    }

    public String prepareNewContact() {
        LOG.info("PREPARE NEW....");
        gridItems = new ArrayList<>();
        model = new DynaFormModel();

//        FluidGridItem item3 = new FluidGridItem("sad","input");
//        gridItems.add(item3);
        UserAttribute att2 = new UserAttribute("code", true, "ert");
        FluidFormField f2 = new FluidFormField(att2, true, null);
        f2.setLabel(att2.getAttribute());
        FluidGridItem item2 = new FluidGridItem(f2, "registercode");
        gridItems.add(item2);

        UserAttribute att1 = new UserAttribute("firstName", true, "[a-z]{3}");
        FluidFormField f = new FluidFormField(att1, true, null);
        f.setLabel(att1.getAttribute());
        FluidGridItem item = new FluidGridItem(f, "input");
        gridItems.add(item);

        // dynaform
        //model = new DynaFormModel();
        DynaFormRow row = model.createRegularRow();
        DynaFormLabel label = row.addLabel(att1.getAttribute(), 1, 1);
        row = model.createRegularRow();
        DynaFormControl control = row.addControl(f, "input", 1, 1);
        label.setForControl(control);

        row = model.createRegularRow();
        label = row.addLabel(att2.getAttribute(), 1, 1);
        row = model.createRegularRow();
        DynaFormControl control2 = row.addControl(f2, "registercode", 1, 1);
        label.setForControl(control2);

        return "pm:register";
    }

    public String saveNewMobile() {
        return "pm:welcome";
    }

    public List<FluidGridItem> getGridItems() {
        return gridItems;
    }

    public void setGridItems(List<FluidGridItem> gridItems) {
        this.gridItems = gridItems;
    }

    public DynaFormModel getModel() {
        LOG.info("Getting model....");
        return model;
    }

    public void setModel(DynaFormModel model) {
        this.model = model;
    }

    public String getSwitchUrl() {
        return switchUrl;
    }

    public void setSwitchUrl(String switchUrl) {
        this.switchUrl = switchUrl;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}
