package com.jsantos.runningTest;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;



public class Wildcards {

	private int counter = 1;

	public String replaceWildCards(String value, LinkedHashMap<String, Object> storeValues) {
        if(null==value) return value;
		if(value.contains("<random>"))value = value.replace("<random>", StringUtils.leftPad((int) (Math.random() * (1000)) + "", 3, '0'));
		if(value.contains("<random1000>"))value = value.replace("<random1000>", StringUtils.leftPad((int) (Math.random() * (1000)) + "", 3, '0'));
		if(value.contains("<random100>"))value = value.replace("<random100>", StringUtils.leftPad((int) (Math.random() * (100)) + "", 2, '0'));
		if(value.contains("<random2>"))value = value.replace("<random2>", (int) (Math.random() * (3)) + "");
		if(value.contains("<random3>"))value = value.replace("<random3>", (int) (Math.random() * (4)) + "");
		if(value.contains("<random4>"))value = value.replace("<random4>", (int) (Math.random() * (5)) + "");
		if(value.contains("<random5>"))value = value.replace("<random5>", (int) (Math.random() * (6)) + "");
		if(value.contains("<random6>"))value = value.replace("<random6>", (int) (Math.random() * (7)) + "");
		if(value.contains("<random7>"))value = value.replace("<random7>", (int) (Math.random() * (8)) + "");
		if(value.contains("<random8>"))value = value.replace("<random8>", (int) (Math.random() * (9)) + "");
		if(value.contains("<random9>"))value = value.replace("<random9>", (int) (Math.random() * (10)) + "");
		if(value.contains("<random10>"))value = value.replace("<random10>", (int) (Math.random() * (11)) + "");
		if(value.contains("<random2+1>"))value = value.replace("<random2+1>", (int) (Math.random() * (2)+1) + "");
		if(value.contains("<random3+1>"))value = value.replace("<random3+1>", (int) (Math.random() * (3)+1) + "");
		if(value.contains("<random4+1>"))value = value.replace("<random4+1>", (int) (Math.random() * (4)+1) + "");
		if(value.contains("<random5+1>"))value = value.replace("<random5+1>", (int) (Math.random() * (5)+1) + "");
		if(value.contains("<random6+1>"))value = value.replace("<random6+1>", (int) (Math.random() * (6)+1) + "");
		if(value.contains("<random7+1>"))value = value.replace("<random7+1>", (int) (Math.random() * (7)+1) + "");
		if(value.contains("<random8+1>"))value = value.replace("<random8+1>", (int) (Math.random() * (8)+1) + "");
		if(value.contains("<random9+1>"))value = value.replace("<random9+1>", (int) (Math.random() * (9)+1) + "");
		if(value.contains("<random10+1>"))value = value.replace("<random10+1>", (int) (Math.random() * (10)+1) + "");
		
		if(value.contains("<counter+>"))
			value = value.replace("<counter+>", counter++ + "");
		if(value.contains("<counter>"))value = value.replace("<counter>", counter + "");
/*
		if(value.contains("<image>"))value = value.replaceAll("<image>", ImageExample.imagesLocation + ImageExample.getImageName(null));
		if(value.contains("<imageLocation"))value = value.replaceAll("<imageLocation>", ImageExample.imagesLocation);
		if(value.contains("<imageName>"))value = value.replaceAll("<imageName>", ImageExample.getImageName(null));
		value = ImageExample.checkImageList(value);
*/
		try {
			if(null!=storeValues)
				value = checkpostingDate(value, storeValues);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;
	}

	private String checkpostingDate(String value, LinkedHashMap<String, Object> storeValues) throws ParseException {
		DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss'Z'" );
		final String regexPostingAdd = "(<postingDate+\\d+>)";
		final Pattern patternPostingAdd = Pattern.compile(regexPostingAdd);
		final String regexPostingRest = "(<postingDate-\\d+>)";
		final Pattern patternPostingRest = Pattern.compile(regexPostingRest);

		if (null != value) {
			Matcher matcher = patternPostingAdd.matcher(value);
			while (matcher.find()) {
				System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					String label = matcher.group(i);
					String number=label.replace("<postingDate+", "").replace(">", "");
					CharSequence  postingdate=(CharSequence) storeValues.get("postingDate");
					LocalDateTime date= LocalDateTime.parse(postingdate, f);
					date=date.plus(-Integer.parseInt(number), ChronoUnit.MINUTES);
					value = value.replace(label, date.format(f));
				}
			}
			matcher = patternPostingRest.matcher(value);
			while (matcher.find()) {
				System.out.println("Full match: " + matcher.group(0));
				for (int i = 1; i <= matcher.groupCount(); i++) {
					String label = matcher.group(i);
					String number=label.replace("<postingDate-", "").replace(">", "");
					CharSequence  postingdate=(CharSequence) storeValues.get("postingDate");
					LocalDateTime date= LocalDateTime.parse(postingdate, f);
					date=date.plus(-Integer.parseInt(number), ChronoUnit.MINUTES);
					value = value.replace(label, date.format(f));
				}
			}
		}
		return value;
	}

	static public String addCommaToWildCard(String value) throws ParseException {
		final String regex1 = "([^\"]<\\S*>[^\"^>])";
		final Pattern pattern1 = Pattern.compile(regex1);
		final String regex2 = "(<\\S*>)";
		final Pattern pattern2 = Pattern.compile(regex2);
		
		if (null != value) {
			
			boolean goaway=true;
			while(goaway) {
				Matcher matcher = pattern1.matcher(value);
				if (matcher.find()) {
					System.out.println("Full match: " + matcher.group(0));
					Integer count=matcher.groupCount();
					for (int i = 1; i <= count; i++) {
						String label = matcher.group(i);
						Matcher matcher2 = pattern2.matcher(label);
						if (matcher2.find()) {
							System.out.println("Full match: " + matcher2.group(0));
							for (int j = 1; j <= matcher2.groupCount(); j++) {
								String label2 = matcher2.group(j);
								value=value.replaceAll(label2,"\""+label2+"\"");
							}	
						}					
					}
				}else goaway=false;
			}
		}
		return value;
	}
	
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}