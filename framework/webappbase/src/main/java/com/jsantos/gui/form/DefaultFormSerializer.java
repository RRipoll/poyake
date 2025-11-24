package com.jsantos.gui.form;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.gui.zkutil.ZulDataWirer;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class DefaultFormSerializer implements IFormSerializer {

	@Override
	public boolean serialize(MTForm form) {

			for (IDetachedRecord dr : form.getDrs().values())
				ZulDataWirer.readFormFieldValues(dr, form.getFormComponent());

			for (IDetachedRecord targetDR : form.getDrs().values()) {
				for (MTField targetField : targetDR.getTable().getFields()) {
					if (null == targetDR.get(targetField) && null != targetField.getForeignKey()) {
						MTTable targetFK = targetField.getForeignKey();
						if (form.getDrs().containsKey(targetFK) && null != form.getDrs().get(targetFK).getPk())
							targetDR.set(targetField, form.getDrs().get(targetFK).getPk());
						else {
							for (IDetachedRecord checkDR : form.getDrs().values()) {
								if (!checkDR.equals(targetDR)) {
									for (MTField checkField : checkDR.getTable().getFields()) {
										if (null != checkField.getForeignKey()) {
											MTTable checkFK = checkField.getForeignKey();
											if ((checkFK.equals(targetFK)
													|| checkFK.getRealFKTOTable().equals(targetFK))
													&& null != checkDR.get(checkField))
												targetDR.set(targetField, checkDR.get(checkField));
										}
									}
								}
							}
						}
					}
				}
					if (shouldBeInserted(targetDR)) {
						
						ObjectMapper mapper = new ObjectMapper();
					mapper.setSerializationInclusion(Include.NON_NULL);
					
					try {
						String data = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(targetDR.getCopyValues()));
					    System.out.println(data);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					targetDR.insertOrUpdate();
			}}
		return true;
	}
}
