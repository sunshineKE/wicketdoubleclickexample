package com.mycompany.doubleclickcomponents;

import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;

import com.mycompany.doubleclickbehavior.PreventDoubleClickBehaviorButtons;

public class NoDoubleClickAjaxButton extends AjaxButton {

	public NoDoubleClickAjaxButton(String id) {
		super(id);
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
		super.updateAjaxAttributes(attributes);

		attributes.getAjaxCallListeners().add(new PreventDoubleClickBehaviorButtons());
	}
}
