package xxy;

import java.io.IOException;

public class Main {

	private static final String file = "sample.csv";
	
	public static void main(String[] args) throws IOException {
		
		ParseCSV p = new  ParseCSV(file);
		XXY xxy = new XXY();
		p.parse(xxy);
		System.out.println(" Œ––≈Àﬂ÷»ﬂ x1y " + xxy.corrX1Y());
		System.out.println(" Œ––≈Àﬂ÷»ﬂ x2y " + xxy.corrX2Y());
		System.out.println(" Œ––≈Àﬂ÷»ﬂ x1x2 " + xxy.corrX1X2());
		System.out.println("b0 " + xxy.b0());
		System.out.println("b1 " + xxy.b1());
		System.out.println("b2 " + xxy.b2());		
	}

}
