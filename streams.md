| # | Program | Concepts Practiced |
|:--|:--|:--|
| 1 | **Find all even numbers** from a List of Integers | Filtering |
| 2 | **Find all strings starting with "A"** from a List of Strings | Filtering |
| 3 | **Find the maximum number** in a List of Integers | Reduce / Aggregate |
| 4 | **Sum of all numbers** in a List | Reduce |
| 5 | **Sort a list of strings** alphabetically | Sorting |
| 6 | **Sort list of employees by salary** (Employee class: name, salary) | Custom Comparator |
| 7 | **Convert List of Strings to Uppercase** | Mapping |
| 8 | **Create a list of squares** from a list of numbers | Mapping |
| 9 | **Remove duplicates** from a list of integers | Distinct elements |
| 10 | **Count frequency of each word** in a List<String> | Grouping and Counting |
| 11 | **Find the first element greater than 50** from List<Integer> | FindFirst / Filtering |
| 12 | **Partition numbers into even and odd lists** | Partitioning |
| 13 | **Group employees by department** | GroupingBy |
| 14 | **Flatten a list of lists** into a single list (List<List<Integer>> to List<Integer>) | flatMap |
| 15 | **Find second highest number** from List<Integer> | Custom Sorting + Skip |

---

```java

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
```
