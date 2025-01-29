public class Main {
    public static void main(String[] args) {
        int value = 4;
        int[] array = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9};
        int size = array.length; // 10
        int newSize = ArrayValueRemover.removeValue(array, value); // 8
        System.out.println("New array size after removal: " + newSize);
    }
}