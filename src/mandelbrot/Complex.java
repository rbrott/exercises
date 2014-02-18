package mandelbrot;

public class Complex {
		
	double real, imag;
	
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	public Complex(Complex other) {
		this.real = other.getReal();
		this.imag = other.getImag();
	}
	
	public double getImag() {
		return imag;
	}
	
	public double getReal() {
		return real;
	}
	
	public Complex multiply(Complex other) {
		double real1 = getReal() * other.getReal();
		double real2 = -1 * getImag() * other.getImag();
		double imag1 = getImag() * other.getReal();
		double imag2 = getReal() * other.getImag();
		return new Complex(real1 + real2, imag1 + imag2);
	}
	
	public Complex add(Complex other) {
		return new Complex(getReal() + other.getReal(), getImag() + other.getImag());
	}
	
}
