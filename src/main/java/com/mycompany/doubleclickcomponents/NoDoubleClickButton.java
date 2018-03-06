package com.mycompany.doubleclickcomponents;

import org.apache.wicket.markup.html.form.Button;

import com.mycompany.doubleclickbehavior.PreventDoubleClickBehaviorButtons;

public class NoDoubleClickButton extends Button {

	public NoDoubleClickButton(String id) {
		super(id);
	}

	@Override
	protected String getOnClickScript() {
		return PreventDoubleClickBehaviorButtons.getEnableDisableJavascript(NoDoubleClickButton.this, true);
	}

}
