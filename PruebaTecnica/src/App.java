import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class App {

	public void invertirTexto(String text) {
		StringBuilder inverso = new StringBuilder(text);
		System.out.println(inverso.reverse().toString());
	}

	public void countCharacter(String text) {
		int counter[] = new int[256];

		for (int i = 0; i < text.length(); i++) {
			counter[text.charAt(i)]++;
		}

		for (int i = 0; i < 256; i++) {
			if (counter[i] != 0) {
				System.out.println((char) i + ": " + counter[i]);
			}
		}

	}
	
	public void repeatedCharacter(String text) {
		int counter[] = new int[256];

		for (int i = 0; i < text.length(); i++) {
			counter[text.charAt(i)]++;
		}

		for (int i = 0; i < 256; i++) {
			if (counter[i] > 1) {
				System.out.println((char) i + ": " + counter[i]);
			}
		}

	}


	public void isMultipleOf(int valor, int number) {
		if(valor % number == 0 ) {
			System.out.println("Is Multiple");
		} else {
			System.out.println("Not Multiple");
		}
	}
	
	public void esBisiesto(int year) {
		boolean isLeapYear = LocalDate.of(year, 1, 1).isLeapYear();
		
		System.out.println("El año " + year +" es Bisiesto = " + isLeapYear );
	}
	
	public void randomOrderString(String text) {
		System.out.println("randomOrderString");
		String[] arreglo = text.split("");
		List<String> lista = Arrays.asList(arreglo);
		Collections.shuffle(lista);
		lista.forEach(System.out::println);
	}
	
	public void getOnlyNotDuplicatesList(List<Integer> list) {
		System.out.println("getOnlyNotDuplicatesList");
		Set<Integer> setList = new HashSet<>(list);
		setList.forEach(System.out::println);
	}
	
	public void vowelIsPresent(String text) {
		System.out.println("vowelIsPresent");
		boolean result =text.matches(".*[a,e,i,o,u].*");
		System.out.println(result);
		
		Pattern VOWELS_PATTERN = Pattern.compile(".*[aeiou].*",Pattern.CASE_INSENSITIVE);
		System.out.println(VOWELS_PATTERN.matcher(text).matches());
	}
	
	public void ispalidrome(String text) {
		boolean result=true;
		int length =text.length();
		
		for (int i = 0; i < length/2; i++) {
			if (text.charAt(i) != text.charAt(length- i - 1))  {
				result = false;
				break;
			}
		}
		
		System.out.println("El resultado de palidrome es: " +result);
	}
	
	public static void main(String[] args) {
		App app = new App();
		
		//cuenta los caracteres que hay en una cadena
		app.countCharacter("jisashi");
		
		//Muestra los caracteres repetidos
		app.repeatedCharacter("Jisashi");
		
		//Muestra si es o no multiplo de un numero
		app.isMultipleOf(10, 3);
		
		//Muestra si un año es Bisiesto
		app.esBisiesto(2020);
		
		//Muestra de manera aleatoria los caracteres de una cadena
		app.randomOrderString("jisashi");
		
		//Muestra los numero que no estan duplicados en una lista
		app.getOnlyNotDuplicatesList(Arrays.asList(1,2,3,4,5,5,1,2,9));
		
		app.vowelIsPresent("jisashi");
		
		app.ispalidrome("oro");
		
	}

}
