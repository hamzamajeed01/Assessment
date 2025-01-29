
import java.util.logging.Logger;
import java.util.logging.Level;

public class ArrayValueRemover {
    private static final Logger LOGGER = Logger.getLogger(ArrayValueRemover.class.getName());

    /**
     * Removes all occurrences of targetValue from the array.
     * Uses the **swap-with-last approach** to minimize unnecessary shifts.
     * @param array The input array.
     * @param targetValue The value to remove.
     * @return The new size of the array after removal.
     */
    public static int removeValue(int[] array, int targetValue) {
        LOGGER.log(Level.INFO, "Starting removal of value: {0}", targetValue);
        if (array == null) {
            LOGGER.log(Level.SEVERE, "Input array is null.");
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (array.length == 0) {
            LOGGER.log(Level.WARNING, "Empty array provided.");
            throw new IllegalArgumentException("Input array is empty.");
        }
        int newSize = array.length;
        int currentIndex = 0;
        int removedCount = 0;
        try {
            while (currentIndex < newSize) {
                if (array[currentIndex] == targetValue) {
                    if (currentIndex != newSize - 1) {
                        array[currentIndex] = array[newSize - 1];
                    }
                    newSize--;
                    removedCount++;
                } else {
                    currentIndex++;
                }
            }
            if (removedCount == 0) {
                LOGGER.log(Level.WARNING, "No occurrences of {0} found. No changes made.", targetValue);
            } else {
                LOGGER.log(Level.INFO, "Successfully removed {0} elements. New size: {1}", new Object[]{removedCount, newSize});
            }
            return newSize;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error occurred during array modification", e);
            return array.length;
        }
    }
}
