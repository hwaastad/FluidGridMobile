/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fluidgridmobile.validator;

import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.omnifaces.util.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@FacesValidator("registerCodeValidator")
public class RegisterCodeValidator implements Validator {
    
    private static final Logger LOG = LoggerFactory.getLogger(RegisterCodeValidator.class);

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Map<String, Object> componentMap = component.getAttributes();
        String pattern = (String) componentMap.get("pattern");
        LOG.info("mathing pattern: {} Value: {}",pattern,value);
        if (pattern == null) {
            throw new ValidatorException(Messages.createFatal("internal error"));
        }
        if (!pattern.equals(value)) {
            throw new ValidatorException(Messages.createError("code error"));
        }
    }

}
