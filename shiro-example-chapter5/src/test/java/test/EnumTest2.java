package test;

public class EnumTest2 {

	public static void main(String[] args) {
		for(EnumTest et:EnumTest.values()){
			System.out.println(et.name());
			System.out.println(et.values());
			System.out.println(et.ordinal());
			System.out.println(et.toString());
			System.out.println(et.getClass());
			System.out.println("---------");
		}
	}
}
