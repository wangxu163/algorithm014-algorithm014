public class PrintUtils {

    public static void print(int[] arr) {
        if (arr.length == 0) {
           return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int item : arr) {
            sb.append(item + ",");
        }
        String substring = sb.toString().substring(0, sb.toString().lastIndexOf(","));
        System.out.println(substring+"]");
    }

}
