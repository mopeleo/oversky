package org.oversky.gurms.test;

//使用assertThat()方法时要引入junit4的jar包
import static org.junit.Assert.*;
//使用is()方法首先需要引入hamcrest-library的jar包
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//1.更改默认的测试运行器为RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class ParameterTest {
	// 2.声明变量存放预期值和测试数据
	private String firstName;
	private String lastName;

	// 3.声明一个返回值 为Collection的公共静态方法，并使用@Parameters进行修饰
	@Parameterized.Parameters //
	public static List<Object[]> param() {
		// 这里我给出两个测试用例
		return Arrays.asList(new Object[][] { { "Mike", "Black" }, { "Cilcln", "Smith" } });
	}

	// 4.为测试类声明一个带有参数的公共构造函数，并在其中为之声明变量赋值
	public ParameterTest(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// 5. 进行测试，发现它会将所有的测试用例测试一遍
//	@Test
	public void test() {
		String name = firstName + " " + lastName;
		assertThat("Mike Black", is(name));
	}
	
	//超时测试
//	@Test(timeout = 1000)
    public void testTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Complete");
    }

	//异常测试
	@Test(expected = NullPointerException.class)
    public void testNullException() {
        throw new NullPointerException();
    }
}
