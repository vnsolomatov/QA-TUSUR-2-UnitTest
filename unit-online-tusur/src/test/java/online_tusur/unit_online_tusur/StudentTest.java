package online_tusur.unit_online_tusur;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StudentTest {
	/*объект тестового класса  Student*/
	private Student s = new Student();	 	  
	  @Test	/* проверка возраста студента, выходящего за диапазон */ //тест дан в исходном коде проекта
	  void test_assert() {
		int age = 26;
		s.setAge(age);
	    int expectedAge = 26;
	    int actualsAge=s.getAge();
	    assertEquals(expectedAge, actualsAge);	
	  }	
	  @Test 												//позитивный тест для метода setAge(int age) класса Student
	  @Tag("positive")
	  public void posiTestSetAge() { 
		  for (int age = 18; age < 50; age++) {					                                //фактический возраст студента в диапазоне [18, 49] 
			  s.setAge(age);			 							//записанный возраст студента
			  assertEquals(age > 17 && age < 50 ? age : 18, s.getAge()); 
		  }
	  }
	  @Test 												//негативный тест для метода setAge(int age) класса Student
	  @Tag("negative")
	  public void negaTestSetAge() { 
			  s.setAge('S');			 							//методу setAge(int age) передан аргумент, не являющийся int
			  assertEquals(18, s.getAge()); 
	  }
	  @Test 												//позитивный тест для метода setFirstName(String firstName) класса Student
	  @Tag("positive")
	  public void posiTestFirstName() {		  
		  StringBuilder sb = new StringBuilder("-");
		  for (char ch = 'a'; ch <= 'z'; ch++) {
				sb.setCharAt(0, ch);
				s.setFirstName(sb.toString());						// запись 26 имён, состоящих из одной строчной буквы
				assertTrue(s.getFirstName().charAt(0) >= 'A' && s.getFirstName().charAt(0) <= 'Z');
		  }
	  }
	  @Test													//негативный тест для метода setFirstName(String firstName) класса Student
	  @Tag("negative")
	  public void negaTestFirstName() {		  
			s.setFirstName("abба-2"); 								// запись имени, содержащего отличные от латиницы символы 
			assertEquals("Abба-2", s.getFirstName());
	  }
	  @Test 												//позитивный тест для метода avgAge(Student[] sA) класса Student
	  @Tag("positive")
	  public void posiTestAvgAge() { 
		  Student[] sA = new Student[100];
		  Random random = new Random();
		  int sumAge = 0;
		  for (int i = 0; i < sA.length; i++) {
			  sA[i] = new Student();
			  sA[i].setAge(10 + random.nextInt(89));
			  sumAge += sA[i].getAge();
		  }	 
		  assertEquals(sumAge/sA.length, Student.avgAge(sA)); 		  
	  }
	  @Test													//негативный тест для метода avgAge(Student[] sA) класса Student
	  @Tag("negative")
	  public void negaTestAvgAge() {
		  Student[] sA = {new Student("Ab","Ba",'s')};
		  assertEquals(sA[0].getAge(), Student.avgAge(sA));			//методу avgAge(Student[] sA) передано значение age, не являющееся int
	  }
}
