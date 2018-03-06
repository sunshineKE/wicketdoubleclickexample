package com.mycompany.doubleclickcomponents;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.resource.JQueryPluginResourceReference;

import com.mycompany.doubleclickbehavior.PreventDoubleClickBehaviorLinks;

public class NoDoubleClickLink<T> extends Link<T> {

	public NoDoubleClickLink(String id) {
		super(id);
		setOutputMarkupId(true);
	}

	@Override
	protected CharSequence getOnClickScript(CharSequence url) {
		return PreventDoubleClickBehaviorLinks.getDisableJavascript(NoDoubleClickLink.this);
	}

	@Override
	public void onClick() {

	}

	@Override
	public void renderHead(IHeaderResponse response) {
		response.render(JavaScriptHeaderItem.forReference(
				new JQueryPluginResourceReference(NoDoubleClickLink.class, "../doubleclickbehavior/disableComponent.js")));

		super.renderHead(response);
	}
}
