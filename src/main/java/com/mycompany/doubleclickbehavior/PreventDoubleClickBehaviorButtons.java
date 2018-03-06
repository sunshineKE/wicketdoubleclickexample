package com.mycompany.doubleclickbehavior;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.AjaxCallListener;

public class PreventDoubleClickBehaviorButtons extends AjaxCallListener {

	private static final String enableDisableJavascriptPointerEvents = ";$('#%s').css('pointer-events', '%s');";
	
	public PreventDoubleClickBehaviorButtons() {
		super();
	}

	@Override
	public CharSequence getBeforeHandler(Component component) {
		return getEnableDisableJavascript(component, true);
	}

	@Override
	public CharSequence getCompleteHandler(Component component) {
		return getEnableDisableJavascript(component, false);
	}

	@Override
	public CharSequence getFailureHandler(Component component) {
		return getEnableDisableJavascript(component, false);
	}

	public static String getEnableDisableJavascript(Component component, boolean disabled) {
		return String.format(enableDisableJavascriptPointerEvents, component.getMarkupId(), disabled ? "none" : "");
	}
}
