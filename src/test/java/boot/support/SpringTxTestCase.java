package boot.support;

import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import boot.app.App;

/**
 * spring junit4 集成测试类
 * @author jinjunzhu
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringApplicationConfiguration(classes = App.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration 
public abstract class SpringTxTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	protected DataSource dataSource;

	protected JdbcTemplate jdbcTemplate;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 确认条件是true
	 * @param message
	 * @param condition
	 */
	protected void assertTrue(String message, boolean condition) {
		org.junit.Assert.assertTrue(message, condition);
	}

	/**
	 * Asserts that a condition is true. If it isn't it throws an
	 * {@link AssertionError} without a message.
	 * 
	 * @param condition
	 *            condition to be checked
	 */
	protected void assertTrue(boolean condition) {
		org.junit.Assert.assertTrue(condition);
	}

	/**
	 * Asserts that a condition is false. If it isn't it throws an
	 * {@link AssertionError} with the given message.
	 * 
	 * @param message
	 *            the identifying message for the {@link AssertionError} (<code>null</code>
	 *            okay)
	 * @param condition
	 *            condition to be checked
	 */
	protected void assertFalse(String message, boolean condition) {
		org.junit.Assert.assertFalse(message, condition);
	}

	/**
	 * Asserts that a condition is false. If it isn't it throws an
	 * {@link AssertionError} without a message.
	 * 
	 * @param condition
	 *            condition to be checked
	 */
	protected void assertFalse(boolean condition) {
		org.junit.Assert.assertFalse(condition);
	}

	/**
	 * Asserts that two objects are equal. If they are not, an
	 * {@link AssertionError} without a message is thrown. If
	 * <code>expected</code> and <code>actual</code> are <code>null</code>,
	 * they are considered equal.
	 * 
	 * @param expected
	 *            expected value
	 * @param actual
	 *            the value to check against <code>expected</code>
	 */
	protected void assertEquals(Object expected, Object actual) {
		org.junit.Assert.assertEquals(expected, actual);
	}

	/**
	 * Asserts that two longs are equal. If they are not, an
	 * {@link AssertionError} is thrown.
	 * 
	 * @param expected
	 *            expected long value.
	 * @param actual
	 *            actual long value
	 */
	protected void assertEquals(long expected, long actual) {
		org.junit.Assert.assertEquals(expected, actual);
	}

	/**
	 * Asserts that two longs are equal. If they are not, an
	 * {@link AssertionError} is thrown with the given message.
	 * 
	 * @param message
	 *            the identifying message for the {@link AssertionError} (<code>null</code>
	 *            okay)
	 * @param expected
	 *            long expected value.
	 * @param actual
	 *            long actual value
	 */
	protected void assertEquals(String message, long expected, long actual) {
		org.junit.Assert.assertEquals(message, (Long) expected, (Long) actual);
	}

	/**
	 * Asserts that two doubles or floats are equal to within a positive delta.
	 * If they are not, an {@link AssertionError} is thrown. If the expected
	 * value is infinity then the delta value is ignored.NaNs are considered
	 * equal: <code>assertEquals(Double.NaN, Double.NaN, *)</code> passes
	 * 
	 * @param expected
	 *            expected value
	 * @param actual
	 *            the value to check against <code>expected</code>
	 * @param delta
	 *            the maximum delta between <code>expected</code> and
	 *            <code>actual</code> for which both numbers are still
	 *            considered equal.
	 */
	protected void assertEquals(double expected, double actual, double delta) {
		org.junit.Assert.assertEquals(expected, actual, delta);
	}

	/**
	 * Asserts that an object isn't null. If it is an {@link AssertionError} is
	 * thrown with the given message.
	 * 
	 * @param message
	 *            the identifying message for the {@link AssertionError} (<code>null</code>
	 *            okay)
	 * @param object
	 *            Object to check or <code>null</code>
	 */
	protected void assertNotNull(String message, Object object) {
		org.junit.Assert.assertNotNull(message, object);
	}

	/**
	 * Asserts that an object isn't null. If it is an {@link AssertionError} is
	 * thrown.
	 * 
	 * @param object
	 *            Object to check or <code>null</code>
	 */
	protected void assertNotNull(Object object) {
		org.junit.Assert.assertNotNull(object);
	}

	/**
	 * Asserts that an object is null. If it is not, an {@link AssertionError}
	 * is thrown with the given message.
	 * 
	 * @param message
	 *            the identifying message for the {@link AssertionError} (<code>null</code>
	 *            okay)
	 * @param object
	 *            Object to check or <code>null</code>
	 */
	protected void assertNull(String message, Object object) {
		org.junit.Assert.assertNull(message, object);
	}

	/**
	 * Asserts that an object is null. If it isn't an {@link AssertionError} is
	 * thrown.
	 * 
	 * @param object
	 *            Object to check or <code>null</code>
	 */
	protected void assertNull(Object object) {
		org.junit.Assert.assertNull(object);
	}

	/**
	 * Asserts that two objects refer to the same object. If they are not, an
	 * {@link AssertionError} is thrown with the given message.
	 * 
	 * @param message
	 *            the identifying message for the {@link AssertionError} (<code>null</code>
	 *            okay)
	 * @param expected
	 *            the expected object
	 * @param actual
	 *            the object to compare to <code>expected</code>
	 */
	protected void assertSame(String message, Object expected, Object actual) {
		org.junit.Assert.assertSame(message, expected, actual);
	}

	/**
	 * Asserts that two objects refer to the same object. If they are not the
	 * same, an {@link AssertionError} without a message is thrown.
	 * 
	 * @param expected
	 *            the expected object
	 * @param actual
	 *            the object to compare to <code>expected</code>
	 */
	protected void assertSame(Object expected, Object actual) {
		org.junit.Assert.assertSame(expected, actual);
	}

	/**
	 * Asserts that two objects do not refer to the same object. If they do
	 * refer to the same object, an {@link AssertionError} is thrown with the
	 * given message.
	 * 
	 * @param message
	 *            the identifying message for the {@link AssertionError} (<code>null</code>
	 *            okay)
	 * @param unexpected
	 *            the object you don't expect
	 * @param actual
	 *            the object to compare to <code>unexpected</code>
	 */
	protected void assertNotSame(String message, Object unexpected, Object actual) {
		org.junit.Assert.assertNotSame(message, unexpected, actual);
	}

	/**
	 * Asserts that two objects do not refer to the same object. If they do
	 * refer to the same object, an {@link AssertionError} without a message is
	 * thrown.
	 * 
	 * @param unexpected
	 *            the object you don't expect
	 * @param actual
	 *            the object to compare to <code>unexpected</code>
	 */
	protected void assertNotSame(Object unexpected, Object actual) {
		org.junit.Assert.assertNotSame(unexpected, actual);
	}

}
