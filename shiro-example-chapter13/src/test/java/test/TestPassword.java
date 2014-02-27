package test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class TestPassword {
	@Test
	public void test1() {
		String hashAlgorithmName = "md5";
		SimpleHash sh = new SimpleHash(hashAlgorithmName, "123", "wang123abc~!@", 2);
		System.out.println("------------"+sh);
	}
}
