package design_patterns_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import facade.ShapeMaker;
import factory.Shape;
import factory.ShapeFactory;
import filter.Criteria;
import filter.CriteriaFemale;
import filter.CriteriaMale;
import filter.Person;
import singleton.SingleObject;

public class DesignPattern_test {

	@Test
	public void singleton_test() {
		SingleObject object1 = SingleObject.getInstance();
		SingleObject object2 = SingleObject.getInstance();
		assertEquals(object1, object2);

		SingleObject object3 = SingleObject.getInstance();
		assertTrue(object2.equals(object3));

		SingleObject object4 = SingleObject.getInstance();
		assertSame(object3, object4);
	}

	@Test
	public void facade_test() {
		ShapeMaker shapeMaker = new ShapeMaker();
		assertEquals("Draw Circle", shapeMaker.drawCircle());
		assertEquals("Draw Rectangle", shapeMaker.drawRectangle());
		assertEquals("Draw Square", shapeMaker.drawSquare());
	}

	@Test
	public void factory_test() {
		ShapeFactory shapeFactory = new ShapeFactory();

		Shape shape1 = shapeFactory.getShape("CIRCLE");
		assertEquals("Draw Circle", shape1.draw());

		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		assertEquals("Draw Rectangle", shape2.draw());

		Shape shape3 = shapeFactory.getShape("SQUARE");
		assertEquals("Draw Square", shape3.draw());

		assertNull(shapeFactory.getShape("TRIANGLE"));

		assertNull(shapeFactory.getShape(null));
	}

	@Test
	public void filter_test() {
		// Test Case # 1
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Robert", "Male", "Single"));
		persons.add(new Person("John", "Male", "Married"));
		persons.add(new Person("Laura", "Female", "Married"));
		persons.add(new Person("Diana", "Female", "Single"));
		persons.add(new Person("Mike", "Male", "Single"));

		Criteria male = new CriteriaMale();
		Criteria female = new CriteriaFemale();

		List<Person> males = new ArrayList<Person>();
		males.add(new Person("Robert", "Male", "Single"));
		males.add(new Person("John", "Male", "Married"));
		males.add(new Person("Mike", "Male", "Single"));

		List<Person> females = new ArrayList<Person>();
		females.add(new Person("Laura", "Female", "Married"));
		females.add(new Person("Diana", "Female", "Single"));

		List<Person> malesList = male.meetCriteria(persons);
		List<Person> femalesList = female.meetCriteria(persons);

		assertEquals(males.get(0).getName(), malesList.get(0).getName());
		assertEquals(males.get(1).getName(), malesList.get(1).getName());
		assertEquals(males.get(2).getName(), malesList.get(2).getName());

		assertEquals(females.get(0).getName(), femalesList.get(0).getName());
		assertEquals(females.get(1).getName(), femalesList.get(1).getName());

		// Test Case # 2
		List<Person> persons2 = new ArrayList<Person>();
		persons2.add(new Person("Carl", "Male", "Single"));
		persons2.add(new Person("Laura", "Female", "Single"));
		persons2.add(new Person("Mary", "Female", "Married"));
		persons2.add(new Person("Lonny", "Male", "Married"));

		List<Person> males2 = new ArrayList<Person>();
		males2.add(new Person("Carl", "Male", "Single"));
		males2.add(new Person("Lonny", "Male", "Married"));

		List<Person> females2 = new ArrayList<Person>();
		females2.add(new Person("Laura", "Female", "Single"));
		females2.add(new Person("Mary", "Female", "Married"));

		List<Person> malesList2 = male.meetCriteria(persons2);
		List<Person> femalesList2 = female.meetCriteria(persons2);

		assertEquals(males2.get(0).getName(), malesList2.get(0).getName());
		assertEquals(males2.get(1).getName(), malesList2.get(1).getName());

		assertEquals(females2.get(0).getName(), femalesList2.get(0).getName());
		assertEquals(females2.get(1).getName(), femalesList2.get(1).getName());

		// Test Case # 3
		List<Person> persons3 = new ArrayList<Person>();
		persons3.add(new Person("Amy", "Female", "Single"));
		persons3.add(new Person("Marvin", "Male", "Married"));
		persons3.add(new Person("Lana", "Female", "Married"));
		persons3.add(new Person("Mark", "Male", "Single"));
		persons3.add(new Person("Macy", "Female", "Single"));

		List<Person> males3 = new ArrayList<Person>();
		males3.add(new Person("Marvin", "Male", "Married"));
		males3.add(new Person("Mark", "Male", "Single"));

		List<Person> females3 = new ArrayList<Person>();
		females3.add(new Person("Amy", "Female", "Single"));
		females3.add(new Person("Lana", "Female", "Married"));
		females3.add(new Person("Macy", "Female", "Single"));

		List<Person> malesList3 = male.meetCriteria(persons3);
		List<Person> femalesList3 = female.meetCriteria(persons3);

		assertEquals(males3.get(0).getName(), malesList3.get(0).getName());
		assertEquals(males3.get(1).getName(), malesList3.get(1).getName());

		assertEquals(females3.get(0).getName(), femalesList3.get(0).getName());
		assertEquals(females3.get(1).getName(), femalesList3.get(1).getName());
		assertEquals(females3.get(2).getName(), femalesList3.get(2).getName());

	}

}
