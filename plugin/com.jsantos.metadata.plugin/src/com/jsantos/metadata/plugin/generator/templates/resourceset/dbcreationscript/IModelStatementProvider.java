package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript;

import java.util.List;

import com.jsantos.metadata.plugin.dbmanager.IStatementProvider;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.Metadata;
import com.jsantos.metadata.plugin.metaDsl.Sequence;
import com.jsantos.metadata.plugin.metaDsl.SqlNative;

public interface IModelStatementProvider extends IStatementProvider{
	public void setModel(List<Entity> entities, List<Sequence> sequences, List<SqlNative> sqlNativeBlocks, List<Metadata> metadatas);
}
