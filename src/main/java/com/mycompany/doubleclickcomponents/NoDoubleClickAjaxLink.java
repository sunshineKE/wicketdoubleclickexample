package com.mycompany.doubleclickcomponents;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.resource.JQueryPluginResourceReference;

import com.mycompany.doubleclickbehavior.PreventDoubleClickBehaviorLinks;

public class NoDoubleClickAjaxLink<T> extends AjaxLink<T> {

	public NoDoubleClickAjaxLink(String id) {
		super(id);
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
		super.updateAjaxAttributes(attributes);

		attributes.getAjaxCallListeners().add(new PreventDoubleClickBehaviorLinks());
	}

	@Override
	public void onClick(AjaxRequestTarget target) {

	}

	@Override
	public void renderHead(IHeaderResponse response) {
		response.render(JavaScriptHeaderItem.forReference(new JQueryPluginResourceReference(
				NoDoubleClickAjaxButton.class, "../doubleclickbehavior/disableComponent.js")));

		super.renderHead(response);
	}

}
