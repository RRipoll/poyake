package com.jsantos.factory.appinfo;

public interface IProvider {

	public default Object inicialice() {
		return null;
	};
}
