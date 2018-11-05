package xxy;

import java.io.IOException;

public class Main {

	private static final String file = "sample3.csv";

	public static void main(String[] args) throws IOException {

		ParseCSV p = new ParseCSV(file);
		XXY xxy = new XXY();
		p.parse(xxy);
		p.parseStud();
		xxy.setY_solve();
		System.out.println("y = " + XXY.math(xxy.b2()) + "*x2 + " + XXY.math(xxy.b1()) + "*x1 + " + XXY.math(xxy.b0()));
		System.out.println("r = " + XXY.math(xxy.R()));
		System.out.println("Tr = " + XXY.math(xxy.Tr()));
		System.out.println("Tc = " + ParseCSV.student.get(xxy.getX1().size() - 3));
		System.out.println("b0 = " + XXY.math(xxy.b0()));
		System.out.println("Sb0 = " + xxy.Sb0());
		System.out.println("tb0 = " + xxy.b0() / xxy.Sb0());
		System.out.println("b1 = " + XXY.math(xxy.b1()));
		System.out.println("Sb1 = " + xxy.Sb1());
		System.out.println("tb1 = " + xxy.b1() / xxy.Sb1());
		System.out.println("b2 = " + XXY.math(xxy.b2()));
		System.out.println("Sb2 = " + xxy.Sb2());
		System.out.println("tb2 = " + xxy.b2() / xxy.Sb2());

	}

}
