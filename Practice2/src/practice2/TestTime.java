package practice2;

public class TestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t = new Time(12, 0, 0);
		Time t2 = new Time(12, 0, 0);
		System.out.println(t.toUniversal());
		System.out.println(t2.toStandard());
		t.add(t2);
		System.out.println(t.toUniversal());
		System.out.println(t.toStandard());
//		Time t3 = new Time(14, 56, 60); // gives error
		t2.setTime(2, 33, 22);
		t.setTime(5, 33,44);
		System.out.println(t2.toStandard());
		t2.add(t);
		System.out.println(t2.toUniversal());
	}

}
