package com.jsantos.metadata.plugin.naming;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.EnuMetadataRow;

public class MetaDslDeclarativeQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider{

	@Override
	protected QualifiedName qualifiedName(Object ele) {
		try {
			if (ele instanceof Attribute) {
				Attribute attribute = (Attribute)ele;
				if (attribute.eContainer() instanceof Entity){
					Entity entity =(Entity)attribute.eContainer();
					QualifiedName qualifiedName = QualifiedName.create(entity.getName(),attribute.getName());
					if (null != EntityHelper.getSchema(entity))
						qualifiedName = QualifiedName.create(EntityHelper.getSchema(entity), EntityHelper.getSimpleName(entity),attribute.getName());
					return qualifiedName;
				}
				else return super.qualifiedName(ele);
			}
			else if (ele instanceof Entity) {
				Entity entity = (Entity)ele;
				QualifiedName qualifiedName = QualifiedName.create(EntityHelper.getSimpleName(entity));
				if (null != EntityHelper.getSchema(entity))
					qualifiedName = QualifiedName.create(EntityHelper.getSchema(entity), EntityHelper.getSimpleName(entity));
				return qualifiedName;
			}
			else if (ele instanceof EnuMetadataRow) {
				EnuMetadataRow row = (EnuMetadataRow)ele;
				Entity entity = (Entity)row.eContainer();
				QualifiedName qualifiedName = QualifiedName.create(EntityHelper.getSimpleName(entity), row.getName());
				if (null != EntityHelper.getSchema(entity))
					qualifiedName = QualifiedName.create(EntityHelper.getSchema(entity), EntityHelper.getSimpleName(entity), row.getName());
				return qualifiedName;
			}
			else {
				QualifiedName name = super.qualifiedName(ele);
				return name;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
