package myshiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class MyshiroTest {
	@Test
	public void test1(){
        SimpleHash hash = new SimpleHash("md5", "123", "wang123abc~!@", 2);
        String encodedPassword = hash.toHex();
        System.out.println(encodedPassword);
	}
}
