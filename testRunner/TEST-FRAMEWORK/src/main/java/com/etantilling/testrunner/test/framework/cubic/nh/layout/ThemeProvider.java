package com.etantilling.testrunner.test.framework.cubic.nh.layout;

import java.util.Collection;
import java.util.List;

import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.WebApps;
import org.zkoss.zkmax.theme.ResponsiveThemeRegistry;
import org.zkoss.zul.theme.Themes;


public class ThemeProvider extends org.zkoss.zkmax.theme.StandardThemeProvider {

	public ThemeProvider() {
		String name = "nh";
		String display = name.toUpperCase();
		int priority = 1000;
		Themes.register(name, display, priority);
		String edition = WebApps.getEdition();
		if ("EE".equals(edition)) {
			Themes.register(ResponsiveThemeRegistry.TABLET_PREFIX + name, display, priority);
		}
	}
	
	@Override
	public Collection<Object> getThemeURIs(Execution exec, List<Object> uris) {
		Collection<Object> c = super.getThemeURIs(exec, uris);
		c.add("~./nh/js/calendar/css/calendar.css.dsp");
		c.add("~./nh/zul/css/apt/crm.css.dsp");
		c.add("/css/app.css.dsp");
		return c;
	}
	
}
