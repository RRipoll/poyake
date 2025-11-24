package com.jsantos.custom.menu;

import java.util.ArrayList;

public class MenuProvider {
	
static final ArrayList<IMenuProvider> menuProviderList = new ArrayList<>();

	public static ArrayList<IMenuProvider> getList(){
			return menuProviderList;
	}

	public static void logBindings() {
		System.out.println("Custom Detail Containers: ===============================================");
		for (IMenuProvider provider:menuProviderList)
			System.out.println("Custom Menu Provider: " + provider.getProviderName() + " -> " );
		System.out.println("-----------------------------------------------------");
		System.out.println("");
	}

	public static void put(IMenuProvider provider) {
		menuProviderList.add(provider);
	}
}
