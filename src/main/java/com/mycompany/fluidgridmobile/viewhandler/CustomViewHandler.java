/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fluidgridmobile.viewhandler;

import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.FacesContext;
import org.omnifaces.util.Faces;
import org.primefaces.mobile.renderkit.MobileRenderKit;

/**
 *
 * @author helge
 */
public class CustomViewHandler extends ViewHandlerWrapper {

    private final ViewHandler wrapped;

    @Override
    public ViewHandler getWrapped() {
        return this.wrapped;
    }

    public CustomViewHandler(ViewHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String calculateRenderKitId(FacesContext context) {
        Faces.setContext(context);
        System.out.println("Going Mobile " + MobileRenderKit.RENDER_KIT_ID);
        return MobileRenderKit.RENDER_KIT_ID;
    }

}
