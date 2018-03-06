package com.mycompany;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.mycompany.doubleclickcomponents.NoDoubleClickAjaxButton;
import com.mycompany.doubleclickcomponents.NoDoubleClickAjaxLink;
import com.mycompany.doubleclickcomponents.NoDoubleClickButton;
import com.mycompany.doubleclickcomponents.NoDoubleClickLink;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		Form<Void> form = new Form<>("form");

		Link<Void> link = new NoDoubleClickLink<Void>("link") {
			int clickCounter = 0;

			@Override
			public void onClick() {
				clickCounter++;
				System.out.println(clickCounter);
				sleep(2000);

				setResponsePage(AnotherPage.class);
			}

		};
		
		AjaxLink<Void> ajaxlink = new NoDoubleClickAjaxLink<Void>("ajaxlink") {
			int clickCounter = 0;

			@Override
			public void onClick(AjaxRequestTarget target) {
				clickCounter++;
				System.out.println(clickCounter);
				sleep(2000);

				setResponsePage(AnotherPage.class);
			}
		};

		Button button = new NoDoubleClickButton("button") {
			int clickCounter = 0;

			@Override
			public void onSubmit() {
				clickCounter++;
				System.out.println(clickCounter);
				sleep(2000);

				setResponsePage(AnotherPage.class);
			}
		};
		
		AjaxButton ajaxbutton = new NoDoubleClickAjaxButton("ajaxbutton") {
			int clickCounter = 0;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				clickCounter++;
				System.out.println(clickCounter);
				sleep(2000);

				setResponsePage(AnotherPage.class);
			}
		};

		form.add(link);
		form.add(ajaxlink);
		form.add(button);
		form.add(ajaxbutton);

		add(form);
	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
