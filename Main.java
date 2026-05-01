package Tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void processList(List<? extends Number> list) {
        List<Number> sortedList = new ArrayList<>(list);

        Collections.sort(sortedList, new Comparator<Number>() {
            public int compare(Number num1, Number num2) {
                Double val1 = num1.doubleValue();
                Double val2 = num2.doubleValue();
                return val1.compareTo(val2);
            }
        });

        double sum = 0.0;
        Double max = null;

        for (Number num : list) {
            double currentVal = num.doubleValue();
            sum += currentVal;

            if (max == null || currentVal > max) {
                max = currentVal;
            }
        }

        System.out.println("Sorted List: " + sortedList);
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
    }

    public static void main(String[] args) {
        List<Number> mixedList = new ArrayList<>();
        mixedList.add(45);
        mixedList.add(12.5);
        mixedList.add(3);
        mixedList.add(89.9);
        mixedList.add(14);

        processList(mixedList);
    }
}