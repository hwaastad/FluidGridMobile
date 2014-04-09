/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fluidgridmobile.validator;

import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.RegexValidator;
import javax.faces.validator.ValidatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@FacesValidator("extendedRegexpValidator")
public class ExtendedRegexpValidator extends RegexValidator {

    private static final Logger LOG = LoggerFactory.getLogger(ExtendedRegexpValidator.class);

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Map<String,Object> componentMap = component.getAttributes();
        String pattern = (String) componentMap.get("pattern");
        boolean mandatory = (Boolean) componentMap.get("mandatory");
        LOG.info("mathing pattern: {} Value: {} Mandatory: {}",pattern,value,mandatory);
        if ("".equals(value)) {
            return;
        }
        if (pattern != null) {
            setPattern(pattern);
            super.validate(context, component, value);
        }
    }
}
