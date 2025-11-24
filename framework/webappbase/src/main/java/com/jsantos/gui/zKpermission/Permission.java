package com.jsantos.gui.zKpermission;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;
import org.zkoss.zul.Menu;
import org.zkoss.zul.Menuitem;

import com.jsantos.common.util.MapValues;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.zkutil.ComponentTreeTransverser;
//@Slf4j

public class Permission {
	
	public static void checkPermission(Component component) {

		Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeName(component, "permissionId");
		for (Component comp : components) {
			String permissionValueId = (String) comp.getAttribute("permissionValueId");
			
			boolean permitted = isPermitted(comp, Integer.parseInt(permissionValueId));
			if (comp instanceof Menu || comp instanceof Menuitem 
					|| comp instanceof Div) {
				comp.setVisible(permitted);
			} else {
				Method m;
				try {
					m = comp.getClass().getMethod("setDisabled", Boolean.TYPE);
					m.invoke(comp, !permitted);
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
				}
			}
		}
	}

	public static boolean isPermitted(Component comp, Integer permissionvalueId) {
		if(null==permissionvalueId)return true;
		return isGuiElementPermisionEnable((String) comp.getAttribute("permissionId"), permissionvalueId);
	}

	public static Integer getPermissionByShortCode(String shortCode) {
		Integer permission = DesktopHelper.getPermissions().get(shortCode);
		return null==permission?0:permission;

	}

	

	public static boolean isGuiElementPermisionEnable(String guiElementId, Integer permissionvalueId) {
		boolean retValue = true;
				
		MapValues<Integer> vector = (MapValues<Integer>) DesktopHelper.getPermissions();
		if (vector.containsKey(guiElementId)) {
			if (!PermissionFactory.getProvider().hasAnyPermission(vector.get(guiElementId)))
				return false;
		}
		return retValue;
	}
}
