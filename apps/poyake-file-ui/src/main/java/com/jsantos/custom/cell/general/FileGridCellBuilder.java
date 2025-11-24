package com.jsantos.custom.cell.general;

import java.util.List;
import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;

import com.jsantos.common.model.EditMode;
import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.custom.extendeddto.FileGroupExtDTO;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.detail.DetailContainerProvider;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.metadata.MTFileData;
import com.jsantos.metadata.common.FileGroupDTO;
import com.jsantos.metadata.common.StorageFileDTO;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;

/**
 * @author javier santos 
 * @author raul ripoll
 */


public class FileGridCellBuilder implements IGridCellBuilder {
	FileGroupExtDTO ref;
	
	@Override
	public Component buildGridComponent(MTField field, Object value, IDetachedRecord values,Locale locale) {
       
		return createComponent(field.getName(),value,locale);
	}

	public  Component createComponent(String label, Object ref,Locale locale) {
		
		if(null==ref)return null;
		this.ref=new FileGroupExtDTO(((FileGroupDTO) ref).getFileGroupId());
		
		A a= new A();
		
		List<StorageFileDTO> storageFile=this.ref.getStorageFiles();
		if(null==storageFile || storageFile.isEmpty())return null;
		a.setLabel(LabelFactory.getProvider().get("documentation", LocaleFactory.getProvider().getLocale())
				);
		a.addEventListener(Events.ON_CLICK, this::showFiles);
		return a;
		
		
	}
	
	void showFiles(Event event) {
		
		IDetailContainer container=DetailContainerProvider.getDetailContainer(MTFileData.FILESHOW);
		container.setDetachedRecord(MTHelper.copyDetachedRecord(ref, MTFileData.FILESHOW));
		container.setParent(DesktopHelper.getRootComponent());
		container.buildAndShowComponent(EditMode.SHOW);
	}
	
	
	
	@Override
	public MTDataType forModelType() {
		return MTDataTypes.FILE_GROUP;
	}

	
}
