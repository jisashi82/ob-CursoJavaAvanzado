package io.codemalone.pattern.decorator;

public interface DataSource {

	public void writeData(String data);
	public String readData();
}
