package xxy;

import java.util.ArrayList;

public class XXY {

	private ArrayList<Double> x1;
	private ArrayList<Double> x2;
	private ArrayList<Double> y;
	private ArrayList<Double> y_solve;

	public XXY() {
		this.x1 = new ArrayList<Double>();
		this.x2 = new ArrayList<Double>();
		this.y = new ArrayList<Double>();
		this.y_solve = new ArrayList<Double>();
	}

	static public double math(double x) {
		return Math.ceil(x * 1000) / 1000;
	}

	public ArrayList<Double> getX1() {
		return x1;
	}

	public void setX1(ArrayList<Double> x1) {
		this.x1 = x1;
	}

	public ArrayList<Double> getX2() {
		return x2;
	}

	public void setX2(ArrayList<Double> x2) {
		this.x2 = x2;
	}

	public ArrayList<Double> getY() {
		return y;
	}

	public void setY(ArrayList<Double> y) {
		this.y = y;
	}

	public ArrayList<Double> getY_solve() {
		return y_solve;
	}

	public void setY_solve() {

		int cnt = x1.size();
		for (int i = 0; i < x1.size(); i++) {
			y_solve.add(b2() * x2.get(i) + b1() * x1.get(i) + b0());
		}

	}

	public double avX1() {
		double sum = 0;
		int cnt = x1.size();
		for (int i = 0; i < x1.size(); i++) {
			sum += x1.get(i);
		}
		return sum / cnt;
	}

	public double avX1Y() {
		double sum = 0;
		int cnt = x1.size();
		for (int i = 0; i < x1.size(); i++) {
			sum += x1.get(i) * y.get(i);
		}
		return sum / cnt;
	}

	public double avX2() {
		double sum = 0;
		int cnt = x2.size();
		for (int i = 0; i < x2.size(); i++) {
			sum += x2.get(i);
		}
		return sum / cnt;
	}

	public double avX2Y() {
		double sum = 0;
		int cnt = x2.size();
		for (int i = 0; i < x2.size(); i++) {
			sum += x2.get(i) * y.get(i);
		}
		return sum / cnt;
	}

	public double avY() {
		double sum = 0;
		int cnt = y.size();
		for (int i = 0; i < y.size(); i++) {
			sum += y.get(i);
		}
		return sum / cnt;
	}

	public double avX1X2() {
		double sum = 0;
		int cnt = x1.size();
		for (int i = 0; i < x1.size(); i++) {
			sum += x1.get(i) * x2.get(i);
		}
		return sum / cnt;
	}

	public double dispX1() {
		double sum = 0;
		int cnt = x1.size();
		for (int i = 0; i < x1.size(); i++) {
			sum += Math.pow(x1.get(i), 2);
		}
		return sum / cnt - Math.pow(avX1(), 2);
	}

	public double dispY() {
		double sum = 0;
		int cnt = y.size();
		for (int i = 0; i < y.size(); i++) {
			sum += Math.pow(y.get(i), 2);
		}
		return sum / cnt - Math.pow(avY(), 2);
	}

	public double dispX2() {
		double sum = 0;
		int cnt = x2.size();
		for (int i = 0; i < x2.size(); i++) {
			sum += Math.pow(x2.get(i), 2);
		}
		return sum / cnt - Math.pow(avX2(), 2);
	}

	public double sX1() {
		return Math.sqrt(dispX1());
	}

	public double sX2() {
		return Math.sqrt(dispX2());
	}

	public double sY() {
		return Math.sqrt(dispY());
	}

	public double corrX1Y() {
		return (avX1Y() - avX1() * avY()) / (sX1() * sY());
	}

	public double corrX2Y() {
		return (avX2Y() - avX2() * avY()) / (sX2() * sY());
	}

	public double corrX1X2() {
		return (avX1X2() - avX2() * avX1()) / (sX2() * sX1());
	}

	public double b1() {
		double b = (corrX1Y() - corrX2Y() * corrX1X2()) / (1 - Math.pow(corrX1X2(), 2)) * (sY() / sX1());
		return b;
	}

	public double b2() {
		double b = (corrX2Y() - corrX1Y() * corrX1X2()) / (1 - Math.pow(corrX1X2(), 2)) * (sY() / sX2());
		return b;
	}

	public double b0() {
		return avY() - b1() * avX1() - b2() * avX2();
	}

	public double R() {
		return Math.sqrt((Math.pow(corrX1Y(), 2) + Math.pow(corrX2Y(), 2) - 2 * corrX1Y() * corrX2Y() * corrX1X2())
				/ (1 - Math.pow(corrX1X2(), 2)));
	}

	public double Tr() {
		return R() * Math.sqrt((x1.size() - 3) / (1 - R() * R()));
	}

	public double S02() {
		double sum = 0;
		int cnt = y.size();
		for (int i = 0; i < y.size(); i++) {
			sum += Math.pow(y.get(i) - y_solve.get(i), 2);
		}
		return sum / (cnt - 3);

	}

	public double Sx1x2() {
		double sum = 0;
		int cnt = x1.size();
		for (int i = 0; i < x1.size(); i++) {
			sum += (x1.get(i) - avX1()) * (x2.get(i) - avX2());
		}
		return sum;
	}

	public double S2x1() {
		double sum = 0;
		int cnt = x1.size();
		for (int i = 0; i < x1.size(); i++) {
			sum += Math.pow(x1.get(i) - avX1(), 2);
		}
		return sum;
	}

	public double S2x2() {
		double sum = 0;
		int cnt = x2.size();
		for (int i = 0; i < x2.size(); i++) {
			sum += Math.pow(x2.get(i) - avX2(), 2);
		}
		return sum;
	}

	public double Sb0() {
		return Math.sqrt((1.0 / (x1.size()))
				+ ((Math.pow(avX1(), 2) * S2x2() + Math.pow(avX2(), 2) * S2x1() - 2 * avX1() * avX2() * Sx1x2())
						/ (S2x1() * S2x2() - Math.pow(Sx1x2(), 2))) * S02());
	}

	public double Sb1() {
		return Math.sqrt(((S2x2()) / (S2x1() * S2x2() - Math.pow(Sx1x2(), 2))) * S02());
	}

	public double Sb2() {
		return Math.sqrt(((S2x1()) / (S2x1() * S2x2() - Math.pow(Sx1x2(), 2))) * S02());
	}

}
