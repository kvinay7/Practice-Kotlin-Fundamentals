import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.System.out;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList(3,8,5,7,4,1,6,2);
		
		System.out.println("with streams");
		list.stream()
			.filter(x -> x%2==0)	//lamda expression
			.map(Main::multiply)	//method reference
			.sorted()
			.forEach(out::println); 
		
		System.out.println("without streams");
		List<Integer> newList = new ArrayList<>();
		
		for(Integer i:list) {
			if(i%2==0) {
				newList.add(multiply(i));
			}
		}
	
		Collections.sort(newList);
		for(Integer list1:newList) {
			System.out.println(list1);
		}
		
	}
	public static int multiply(int x) {
		return x*2;
	}

}
