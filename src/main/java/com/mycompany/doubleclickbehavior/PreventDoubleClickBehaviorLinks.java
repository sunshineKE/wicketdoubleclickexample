package com.mycompany.doubleclickbehavior;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.AjaxCallListener;

public class PreventDoubleClickBehaviorLinks extends AjaxCallListener {

	private static final String disableJavascriptReplaceTag = "disableLinkByReplace('%s');";
	private static final String enableJavascriptReplaceTag = "enableLinkByReplace('%s');";

	public PreventDoubleClickBehaviorLinks() {
		super();
	}
	
	@Override
	public CharSequence getBeforeHandler(Component component) {
		return getDisableJavascript(component);
	}

	@Override
	public CharSequence getCompleteHandler(Component component) {
		return getEnableJavascript(component);
	}

	@Override
	public CharSequence getFailureHandler(Component component) {
		return getEnableJavascript(component);
	}

	public static String getDisableJavascript(Component component) {
		component.getMarkupAttributes();
		return String.format(disableJavascriptReplaceTag, component.getMarkupId());
	}
	
	public static String getEnableJavascript(Component component) {
		return String.format(enableJavascriptReplaceTag, component.getMarkupId());
	}
}
