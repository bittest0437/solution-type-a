package result;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import problem02.MusicPhone;
import problem02.Phone;
import problem02.SmartPhone;
import problem03.RectTriangle;
import problem03.Rectangle;
import problem03.Resizable;
import problem03.Shape;

public class TestResult {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Test
	public void testProblem01() {
		assertEquals(1, problem01.Main.countClap(3));
		assertEquals(1, problem01.Main.countClap(13));
		assertEquals(0, problem01.Main.countClap(28));
		assertEquals(2, problem01.Main.countClap(33));
		assertEquals(1, problem01.Main.countClap(49));
		assertEquals(0, problem01.Main.countClap(55));
		assertEquals(2, problem01.Main.countClap(69));
		assertEquals(1, problem01.Main.countClap(73));
		assertEquals(2, problem01.Main.countClap(99));
	}
	
	@Test
	public void testProblem02() {
		problem02.Main.main(null);
		assertEquals("통화하기스트리밍앱실행", systemOutRule.getLog().replaceAll("(\\r|\\n|\\r\\n)+", ""));

		Phone phone = new SmartPhone();

		assertEquals("통화하기", phone.call());
		assertEquals("스트리밍", ((MusicPhone) phone).playMusic());
		assertEquals("앱실행", ((SmartPhone) phone).runApp());
	}
	
	@Test
	public void testProblem03() {
		Shape s1 = new Rectangle(5, 6);
		Shape s2 = new RectTriangle(6, 2);

		if(5. * 6. != s1.getArea()) {
			fail();
		}
		if(5. * 2 + 6. * 2 != s1.getPerimeter()) {
			fail();
		}

		if(6. * 2. / 2 != s2.getArea()) {
			fail();
		}
		if(6. + 2. + Math.sqrt(6.*6. + 2.*2.) != s2.getPerimeter()) {
			fail();
		}

		assert(s1 instanceof Resizable);
		Resizable resizable = (Resizable) s1;
		resizable.resize(0.5);
		if(5.* 0.5 * 6. * 0.5 != s1.getArea()) {
			fail();
		}
		if(5. * 0.5 * 2 + 6. * 0.5 * 2 != s1.getPerimeter()) {
			fail();
		}
	}	
}