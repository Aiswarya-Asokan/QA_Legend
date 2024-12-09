package utility;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	Faker faker = new Faker();

	public String creatARandomFirstName() {
	return faker.name().firstName();

	}
	public String creatARandomLastName() {
		return faker.name().lastName();

	}
	public String generateAddress() {
		return faker.address().fullAddress(); 
	}


	public String generateEmail() {
		return faker.internet().emailAddress(); 
	}
	public int generateRandomInt(int min, int max) {
		return faker.number().numberBetween(min, max);
	}

	public String generateRandomDigits(int count) {
		return faker.number().digits(count);
	}

	public int generateRandomNumber() {
		return faker.number().randomDigit();
	}

}
