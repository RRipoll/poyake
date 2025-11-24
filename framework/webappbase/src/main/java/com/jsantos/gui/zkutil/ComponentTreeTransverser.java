package com.jsantos.gui.zkutil;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.metainfo.Annotation;
import org.zkoss.zk.ui.sys.ComponentCtrl;

import com.jsantos.common.util.MTMapValues;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.orm.mt.MTField;

public class ComponentTreeTransverser {
	public static Vector<Component> transverseTree(Component comp) {
		Vector<Component> components = new Vector<Component>();
		recurse(comp, components);
		return components;
	}

	public static Component findChildById(Component parent, String id) {
		for (Object o : parent.getChildren()) {
			if (o instanceof Component) {
				Component comp = (Component) o;
				if (id.equals(comp.getId()))
					return comp;
				Component retValue = findChildById(comp, id);
				if (null != retValue)
					return retValue;
			}
		}
		return null;
	}

	public static Component findFieldEditorFor(Component parent, MTField field) {
		MTMapValues<Component> comps = ComponentTreeTransverser.getMetadataAnotatedComponents(parent);
		if (!comps.isEmpty())
			return comps.get(field);
		return null;

	}

	public static Vector<Component> getComponentsByAttributeName(Component parent, String attributeName) {
		return getComponentsByAttributeValue(parent, attributeName, null);
	}

	public static Vector<Component> getComponentsByAttributeValue(Component parent, String attributeName,
			String attributeValue) {
		Vector<Component> components = new Vector<Component>();
		for (Component comp : transverseTree(parent)) {
			if (null != comp.getAttribute(attributeName)) {
				if (null == attributeValue) {
					components.add(comp);
				} else if (attributeValue.equals(comp.getAttribute(attributeName))) {
					components.add(comp);
				}
			}
		}
		return components;
	}

	public static MTMapValues<Component> getMetadataAnotatedComponents(Component parent) {
		MTMapValues<Component> components = new MTMapValues<Component>();
		for (Component comp : transverseTree(parent)) {
			if (comp instanceof ComponentCtrl && null == comp.getAttribute("nonReadable")) {
				ComponentCtrl compCtrl = (ComponentCtrl) comp;
				Annotation ann = compCtrl.getAnnotation("info", "MT");
				if (null != ann) {
					MTField field = MTAnnotation.getMTField((ComponentCtrl) comp);
					if (null != field && !components.containsKey(field)) {
						components.put(field, comp);
					}
				}
			}
			if (comp instanceof IMTComponent) {
				if (!components.containsValue(comp) && null == comp.getAttribute("nonReadable")) {
					components.put(((IMTComponent) comp).getMTField(), comp);
				}
			}
		}
		return components;
	}

	private static void recurse(Component parent, Vector<Component> components) {
		for (Object o : parent.getChildren()) {
			if (o instanceof Component) {
				Component comp = (Component) o;
				components.add(comp);
				if (0 < comp.getChildren().size())
					recurse(comp, components);
			} 
		}
	}
}
