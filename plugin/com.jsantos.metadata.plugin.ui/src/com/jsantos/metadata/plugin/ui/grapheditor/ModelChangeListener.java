package com.jsantos.metadata.plugin.ui.grapheditor;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;

public class ModelChangeListener implements IResourceChangeListener{
	boolean metadataChanged = false;
	
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (containsMetadata(event.getDelta()))
				metadataChanged = true;
	}
	
	boolean containsMetadata(IResourceDelta delta) {
		if (null == delta || null == delta.getFullPath())
			return false;
		if (delta.getFullPath().toString().contains(".metadata"))
			return true;
		for (IResourceDelta childDelta:delta.getAffectedChildren())
			if (containsMetadata(childDelta))
				return true;
		return false;
	}

	public boolean isMetadataChanged() {
		return metadataChanged;
	}

	public void setMetadataChanged(boolean metadataChanged) {
		this.metadataChanged = metadataChanged;
	}
	
	
}
