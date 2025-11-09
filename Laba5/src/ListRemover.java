import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListRemover {
    //Удаление строки
    public int removeString(List<String> list, String valueToRemove) {
        if (list == null || valueToRemove == null) {
            return 0;
        }

        int removedCount = 0;
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            if (Objects.equals(element, valueToRemove)) {
                iterator.remove();
                removedCount++;
            }
        }
        return removedCount;
    }

    public int removeSubstring(List<String> list, String substring) {
        if (list == null || substring == null) {
            return 0;
        }

        int removedCount = 0;
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element != null && element.contains(substring)) {
                iterator.remove();
                removedCount++;
            }
        }
        return removedCount;
    }
}
