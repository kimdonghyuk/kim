
public class Main {

	public static void main(String[] args) {
		
//		//Chinesecook cook = new Chinesecook();
//		ChineseCook cook = new KangNamCook();
//		
//		cook.makeZaZang();
//		((SeoulCook)cook).makeZamBong(); // cook의 타입이 ChineseCook이므로 타입을 바꾸어주어야함.
		
		ChineseCook[] arr = new ChineseCook[3];
		
		arr[0] = new ChineseCook();
		arr[1] = new SeoulCook();
		arr[2] = new KangNamCook();
		
	}
	
}
