package com.jsantos.metadata.plugin.ui.grapheditor;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class ImageManager {
	static Image primaryKeyImage;
	static Image regularFieldImage;
	static Image foreignKeyImage;
	
	public static Image getPrimaryKeyImage() {
		if (null == primaryKeyImage)
			try {
				primaryKeyImage = ImageDescriptor.createFromURL(new URL("url:platform:/plugin/com.jsantos.metadata.plugin.ui/icons/primaryKeySmall.png")).createImage();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		return primaryKeyImage;
	}

	public static Image getForeignKeyImage() {
		if (null == foreignKeyImage)
			try {
				foreignKeyImage = ImageDescriptor.createFromURL(new URL("url:platform:/plugin/com.jsantos.metadata.plugin.ui/icons/ForeignKeySmall.png")).createImage();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		return foreignKeyImage;
	}

	public static Image getRegularFieldImage() {
		if (null == regularFieldImage)
			try {
				regularFieldImage = ImageDescriptor.createFromURL(new URL("url:platform:/plugin/com.jsantos.metadata.plugin.ui/icons/RegularField.png")).createImage();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		return regularFieldImage;
	}
	
	
}
