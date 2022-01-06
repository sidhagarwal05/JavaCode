package Assignment1;

public class QuesVI {

	public static void main(String[] args) {
		Rectange rectangle = new Rectange(10,15);
		System.out.println("Area : "+rectangle.area());
		System.out.println("Perimeter : "+rectangle.perimeter());

	}
	public static class Rectange{
		int a;
		int b;
		Rectange(int a,int b){
			this.a=a;
			this.b=b;
		}
		public int area() {
			return a*b;
		}
		public int perimeter() {
			return 2*(a+b);
		}
	}
}
