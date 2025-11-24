package com.etantolling.testrunner.test.core.utils;


public class Mod10CheckDigit {

	public static void main(String[] args) {
		System.out.println(calculate("8529831"));
	}

	static int[] weight = { 7, 5, 3, 2 };

	@SuppressWarnings("unused")
	public static int calculate(String ccNumber) {

		int retValue = 0;

		int sum = 0;
		int w = 0;
		for (int i = 0; i < ccNumber.length(); i++) {
			int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			String assignedWeight = (n * weight[(i % 4)]) + "";
			int sumAssignedWeight = 0;
			for (int j = 0; j < assignedWeight.length(); j++) {
				int k = Integer.parseInt(assignedWeight.substring(j, j + 1));
				sumAssignedWeight += k;
			}
			sum += sumAssignedWeight;

			w++;
		}
		retValue = 10 - (sum % 10);
		if (retValue == 10)
			retValue = 0;

		return retValue;
	}
}