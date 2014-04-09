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
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
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

    public String prepareNewContact() {
        LOG.debug("PREPARE NEW....");
        gridItems = new ArrayList<>();
        
//        FluidGridItem item3 = new FluidGridItem("sad","input");
//        gridItems.add(item3);
        
        UserAttribute att1 = new UserAttribute("firstName", true, "[a-z]{3}");
        FluidFormField f = new FluidFormField(att1, true, null);
        f.setLabel(att1.getAttribute());
        FluidGridItem item = new FluidGridItem(f, "input");
        gridItems.add(item);

        UserAttribute att2 = new UserAttribute("code", true, "ert");
        FluidFormField f2 = new FluidFormField(att2, true, null);
        f2.setLabel(att2.getAttribute());
        FluidGridItem item2 = new FluidGridItem(f2, "registercode");
        gridItems.add(item2);

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

}
