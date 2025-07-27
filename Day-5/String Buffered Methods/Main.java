public class Main {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Logic"); 
        sb.append(" While"); // Appending " While"
        System.out.println("After append: " + sb);

        sb.insert(6, "and"); // Inserting "and" at index 6
        System.out.println("After insert: " + sb);

        sb.replace(0, 5, "Loop"); // Replacing "Logic" with "Loop"
        System.out.println("After replace: " + sb);

        sb.delete(4, 8); // Deleting characters from index 4 to 7
        System.out.println("After delete: " + sb);

        sb.reverse(); // Reversing the entire string
        System.out.println("After reverse: " + sb);

        String finalString = sb.toString(); // Converting StringBuffer to String (fixed '=' and syntax)
        System.out.println("Final string: " + finalString); // Fixed print statement
    }
}
