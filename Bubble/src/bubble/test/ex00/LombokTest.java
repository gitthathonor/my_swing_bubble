package bubble.test.ex00;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Dog {
	String name;
}

public class LombokTest {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.setName("토토");
		System.out.println(d.getName());
	}

}
