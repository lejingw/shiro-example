package test;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class MyObj implements Serializable {
	private static MyObj obj = new MyObj();

	private MyObj() {
	}

	public static MyObj getInstace() {
		return obj;
	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println("---"+this);
		return obj;
	}
}
