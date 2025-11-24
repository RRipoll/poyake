package com.jsantos.gui.datagrid4;

import org.zkoss.zk.ui.Component;

import com.jsantos.orm.dbstatement.IDetachedRecord;

public interface IEntity {

	Component build(Component row, IDetachedRecord datarecord);

}