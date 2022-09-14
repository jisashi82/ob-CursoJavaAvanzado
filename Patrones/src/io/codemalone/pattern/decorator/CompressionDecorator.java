package io.codemalone.pattern.decorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator{

	private int compLevel = 6;
	
	public CompressionDecorator(DataSource source) {
		super(source);
	}

	public int getCompLevel() {
		return compLevel;
	}

	public void setCompLevel(int compLevel) {
		this.compLevel = compLevel;
	}
	
	@Override
	public void writeData(String data) {
		super.writeData(compress(data));
	}
	
	@Override
	public String readData() {
		return decompress(super.readData());
	}

	public String compress(String datos) {
		byte[] data = datos.getBytes();
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
			DeflaterOutputStream dos= new DeflaterOutputStream(bout, new Deflater(compLevel));
			dos.write(data);
			dos.close();
			bout.close();
			return Base64.getEncoder().encodeToString(bout.toByteArray());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public String decompress(String datos) {
		byte[] data = Base64.getDecoder().decode(datos);
		try {
			InputStream in = new ByteArrayInputStream(data);
			InflaterInputStream iin= new InflaterInputStream(in);
			ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
			int b;
			while((b = iin.read()) != -1) {
				bout.write(b);
			}
			in.close();
			iin.close();
			bout.close();
			return new String(bout.toByteArray());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
