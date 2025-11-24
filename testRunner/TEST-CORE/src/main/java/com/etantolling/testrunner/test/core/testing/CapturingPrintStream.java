package com.etantolling.testrunner.test.core.testing;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;

public class CapturingPrintStream extends PrintStream{
	PrintStream realOut = null;
	
	
	public CapturingPrintStream(PrintStream originalOut, ByteArrayOutputStream testLog){
		super(testLog);
		realOut = originalOut;
	}


	@Override
	public PrintStream append(char arg0) {
		realOut.append(arg0);
		return super.append(arg0);
	}


	@Override
	public PrintStream append(CharSequence arg0, int arg1, int arg2) {
		realOut.append(arg0, arg1, arg2);
		return super.append(arg0, arg1, arg2);
	}


	@Override
	public PrintStream append(CharSequence arg0) {
		realOut.append(arg0);
		return super.append(arg0);
	}


	@Override
	public boolean checkError() {
		return super.checkError();
	}


	@Override
	protected void clearError() {
		super.clearError();
	}


	@Override
	public void close() {
		realOut.close();
		super.close();
	}


	@Override
	public void flush() {
		realOut.flush();
		super.flush();
	}


	@Override
	public PrintStream format(Locale arg0, String arg1, Object... arg2) {
		realOut.format(arg0, arg1, arg2);
		return super.format(arg0, arg1, arg2);
	}


	@Override
	public PrintStream format(String arg0, Object... arg1) {
		realOut.format(arg0, arg1);
		return super.format(arg0, arg1);
	}


	@Override
	public void print(boolean arg0) {
		super.print(arg0);
	}


	@Override
	public void print(char arg0) {
		super.print(arg0);
	}


	@Override
	public void print(char[] arg0) {
		super.print(arg0);
	}


	@Override
	public void print(double arg0) {
		super.print(arg0);
	}


	@Override
	public void print(float arg0) {
		super.print(arg0);
	}


	@Override
	public void print(int arg0) {
		super.print(arg0);
	}


	@Override
	public void print(long arg0) {
		super.print(arg0);
	}


	@Override
	public void print(Object arg0) {
		super.print(arg0);
	}


	@Override
	public void print(String arg0) {
		super.print(arg0);
	}


	@Override
	public PrintStream printf(Locale arg0, String arg1, Object... arg2) {
		realOut.printf(arg0, arg1, arg2);
		return super.printf(arg0, arg1, arg2);
	}


	@Override
	public PrintStream printf(String arg0, Object... arg1) {
		realOut.printf(arg0, arg1);
		return super.printf(arg0, arg1);
	}


	@Override
	public void println() {
		super.println();
	}


	@Override
	public void println(boolean arg0) {
		super.println(arg0);
	}


	@Override
	public void println(char arg0) {
		super.println(arg0);
	}


	@Override
	public void println(char[] arg0) {
		super.println(arg0);
	}


	@Override
	public void println(double arg0) {
		super.println(arg0);
	}


	@Override
	public void println(float arg0) {
		super.println(arg0);
	}


	@Override
	public void println(int arg0) {
		super.println(arg0);
	}


	@Override
	public void println(long arg0) {
		super.println(arg0);
	}


	@Override
	public void println(Object arg0) {
		super.println(arg0);
	}


	@Override
	public void println(String arg0) {
		super.println(arg0);
	}


	@Override
	protected void setError() {
		super.setError();
	}


	@Override
	public void write(byte[] arg0, int arg1, int arg2) {
		realOut.write(arg0, arg1, arg2);
		super.write(arg0, arg1, arg2);
	}


	@Override
	public void write(int arg0) {
		realOut.write(arg0);
		super.write(arg0);
	}


	@Override
	public void write(byte[] arg0) throws IOException {
		super.write(arg0);
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}


	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}


	@Override
	public int hashCode() {
		return super.hashCode();
	}


	@Override
	public String toString() {
		return super.toString();
	}
}
