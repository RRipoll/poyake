package com.jsantos.auditimmo.screen.evaluation;

import java.util.ArrayList;

import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Text;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.Component;

import com.jsantos.metadata.MT;
import com.jsantos.metadata.eva.VResultCalculationDTO;
import com.jsantos.orm.dbstatement.DetachedQueryResult;

public class EvaluationResult {
	Integer evaluationId;
	Integer evaluationSectionTypeId;
	int[] levelSummary = new int[10];
	int[] colorTotal = new int[3];
	String[] colors = {"lightgreen","yellow", "red"};
	int maxLevel = 0;
	
	public EvaluationResult(Integer evaluationId, Integer evaluationSectionTypeId) {
		this.evaluationId = evaluationId;
		this.evaluationSectionTypeId = evaluationSectionTypeId;
		for (int i=0; i<levelSummary.length; i++)
			levelSummary[i]=0;
	}
	
	public void calculate() {
		DetachedQueryResult dqr = new DetachedQueryResult(MT.VRESULTCALCULATION, " and evaluationId=" + evaluationId + " and evaluationSectionTypeId=" + evaluationSectionTypeId);
		dqr.setPageSize(null);
		ArrayList<VResultCalculationDTO> results = dqr.getPage(0, VResultCalculationDTO.class);
		for (VResultCalculationDTO result:results) {
			if (null != result.getLevel()) {
				levelSummary[result.getLevel()]++;
				if (result.getLevel()>maxLevel)
					maxLevel=result.getLevel();
				if (result.getLevel()>0)
					colorTotal[(result.getLevel()-1)/3]++;
			}
		}
	}
	
	int totalForLevel(int level) {
		return levelSummary[level];
	}
	
	String getResultColor() {
		if (maxLevel<=3) return colors[0];
		if (maxLevel<=6) return colors[1];
		else return colors[2];
	}
	
	void renderTable(Component table) {
		Tr tr = new Tr();
		tr.setParent(table);
		for (int i=0; i<10; i++) {
			Td td = new Td();
			td.setParent(tr);
			new Text(Integer.toString(levelSummary[i])).setParent(td);
		}
		tr = new Tr();
		tr.setParent(table);
		new Td().setParent(tr);
		for (int i=0; i<3; i++) {
			Td td = new Td();
			td.setParent(tr);
			td.setDynamicProperty("colspan", "3");
			td.setStyle("background-color:" + colors[i]);
			new Text(Integer.toString(colorTotal[i])).setParent(td);
		}
	}

	public Integer colorTotal(int group) {
		return colorTotal[group];
	}
}
