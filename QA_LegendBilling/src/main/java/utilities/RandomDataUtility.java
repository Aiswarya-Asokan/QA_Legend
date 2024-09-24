package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
public static Faker faker;
public static String get_Firstname()
{
	faker=new Faker();
	String firstname=faker.name().firstName();
	return firstname;
}

public static String get_Lastname()
{
	faker=new Faker();
	String lastname=faker.name().lastName();
	return lastname;
}
}

