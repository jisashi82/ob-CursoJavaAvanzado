package io.codemalone.pattern.decorator;

public class Demo {
	public static void main(String[] args) {
		
		String salary = "Name,Salary\nJohn Smith,100000\nSteve Nakamura,912000";
		DataSourceDecorator encode = new CompressionDecorator(
				new EncryptionDecorator(
						new FileDataSource("E:/outputdemo.txt")));
		
		encode.writeData(salary);
		DataSource plain = new FileDataSource("E:/outputdemo.txt");
		
		System.out.println("- Input ---------------");
		System.out.println(salary);
		System.out.println("- Encode ---------------");
		System.out.println(plain.readData());
		System.out.println("- Decode ---------------");
		System.out.println(encode.readData());
	}

}
