package com.jsantos.gui.zKpermission;

import org.zkoss.xel.VariableResolver;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.impl.UiEngineImpl;
import org.zkoss.zk.ui.metainfo.PageDefinition;

import java.util.Arrays;
import java.util.Map;


public class PermissionUIEngine extends UiEngineImpl {

    @Override
    public Component[] createComponents(Execution exec, PageDefinition pagedef, Page page, Component parent, Component insertBefore, VariableResolver resolver, Map<?, ?> arg) {
        Component[] components = super.createComponents(exec, pagedef, page, parent, insertBefore, resolver, arg);
        Arrays.stream(components).forEach(Permission::checkPermission);

        return components;
    }
}

