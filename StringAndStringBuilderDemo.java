public class StringAndStringBuilderDemo {
  public static void main(String[] args) {
      // Initial input
      String input = "  Hello, World! Welcome to Java  ";

      // === String Methods ===
      System.out.println("=== String Methods ===");
      
      // 1. charAt: Get character at index 7
      char ch = input.charAt(7);
      System.out.println("charAt(7): " + ch); // Output: W

      // 2. substring: Extract "World" from index 9 to 14
      String substring = input.substring(9, 14);
      System.out.println("substring(9, 14): " + substring); // Output: World

      // 3. split: Split into words by whitespace
      String[] words = input.split("\\s+");
      System.out.print("split(\\s+): ");
      for (String word : words) {
          System.out.print(word + " | ");
      }
      System.out.println(); // Output: | Hello, | World! | Welcome | to | Java |

      // 4. "Delete" (using replace): Remove "World"
      String afterDelete = input.replace("World", "");
      System.out.println("replace('World', ''): " + afterDelete); // Output:   Hello, ! Welcome to Java  

      // 5. "Update" (using replace): Replace "Java" with "Programming"
      String afterUpdate = input.replace("Java", "Programming");
      System.out.println("replace('Java', 'Programming'): " + afterUpdate); // Output:   Hello, World! Welcome to Programming  

      // 6. length: Get string length
      int length = input.length();
      System.out.println("length(): " + length); // Output: 30

      // 7. toLowerCase: Convert to lowercase
      String lower = input.toLowerCase();
      System.out.println("toLowerCase(): " + lower); // Output:   hello, world! welcome to java  

      // 8. toUpperCase: Convert to uppercase
      String upper = input.toUpperCase();
      System.out.println("toUpperCase(): " + upper); // Output:   HELLO, WORLD! WELCOME TO JAVA  

      // 9. indexOf: Find index of "Welcome"
      int index = input.indexOf("Welcome");
      System.out.println("indexOf('Welcome'): " + index); // Output: 15

      // 10. equals: Compare with another string
      boolean equals = input.equals("  Hello, World! Welcome to Java  ");
      System.out.println("equals(input): " + equals); // Output: true

      // 11. compareTo: Compare lexicographically with "Hello"
      int compare = input.compareTo("Hello");
      System.out.println("compareTo('Hello'): " + compare); // Output: negative value (as input > "Hello")

      // 12. toCharArray: Convert to character array
      char[] chars = input.toCharArray();
      System.out.print("toCharArray(): ");
      for (char c : chars) {
          System.out.print(c + " ");
      }
      System.out.println(); // Output:   H e l l o ,   W o r l d !   W e l c o m e   t o   J a v a  

      // 13. startsWith: Check if starts with "  Hello"
      boolean startsWith = input.startsWith("  Hello");
      System.out.println("startsWith('  Hello'): " + startsWith); // Output: true

      // 14. endsWith: Check if ends with "Java  "
      boolean endsWith = input.endsWith("Java  ");
      System.out.println("endsWith('Java  '): " + endsWith); // Output: true

      // 15. trim: Remove leading/trailing whitespace
      String trimmed = input.trim();
      System.out.println("trim(): " + trimmed); // Output: Hello, World! Welcome to Java

     
    
    
    // === StringBuilder Methods ===
      System.out.println("\n=== StringBuilder Methods ===");
      
      // 1. Initialization
      StringBuilder sb = new StringBuilder("Hello, World! Welcome to Java");

      // 2. append: Append " Programming"
      sb.append(" Programming");
      System.out.println("append(' Programming'): " + sb); // Output: Hello, World! Welcome to Java Programming

      // 3. insert: Insert "Greetings: " at index 0
      sb.insert(0, "Greetings: ");
      System.out.println("insert(0, 'Greetings: '): " + sb); // Output: Greetings: Hello, World! Welcome to Java Programming

      // 4. delete: Delete "World" (indices 13 to 18)
      sb.delete(13, 18);
      System.out.println("delete(13, 18): " + sb); // Output: Greetings: Hello, ! Welcome to Java Programming

      // 5. "Update" (setCharAt): Change first character to 'g'
      sb.setCharAt(0, 'g');
      System.out.println("setCharAt(0, 'g'): " + sb); // Output: greetings: Hello, ! Welcome to Java Programming

      // 6. "Get" (charAt): Get character at index 10
      char sbChar = sb.charAt(10);
      System.out.println("charAt(10): " + sbChar); // Output: H

      // 7. reverse: Reverse the entire StringBuilder
      sb.reverse();
      System.out.println("reverse(): " + sb); // Output: gnimmargorP avaJ ot emocleW ! ,olleH :sgniteerg

      // 8. toString: Convert to String
      String sbString = sb.toString();
      System.out.println("toString(): " + sbString); // Output: gnimmargorP avaJ ot emocleW ! ,olleH :sgniteerg

      // 9. length: Get StringBuilder length
      int sbLength = sb.length();
      System.out.println("length(): " + sbLength); // Output: 42

      // 10. setLength: Set length to 20 (truncate)
      sb.setLength(20);
      System.out.println("setLength(20): " + sb); // Output: gnimmargorP avaJ ot e

      // 11. substring: Extract substring from index 0 to 10
      String sbSubstring = sb.substring(0, 10);
      System.out.println("substring(0, 10): " + sbSubstring); // Output: gnimmargor

      // 12. indexOf: Find index of "ava"
      int sbIndex = sb.indexOf("ava");
      System.out.println("indexOf('ava'): " + sbIndex); // Output: 11
  }
}
