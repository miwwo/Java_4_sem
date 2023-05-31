//5) Имплементировать интерфейс Comparator, сравнивающий две строки
//по сумме всех чисел, представленных в строке.

public class Main {
    @FunctionalInterface
    public interface Comparator<T> {
        int compare(T o1, T o2);
    }
    public static String compare(String s1, String s2){
        String res;
        int sum1 = 0;
        int sum2 = 0;
        for (char ch: s1.toCharArray()) {
            if (Character.isDigit(ch))
                sum1+= (int)ch;
        }
        for (char ch: s2.toCharArray()) {
            if (Character.isDigit(ch))
                sum2+= (int)ch;
        }
        res = sum1 > sum2 ? s1 : s2;
        return res;
    }
    public static void main(String[] args) {
        String s1 = new String("3dfg847h5"); //27
        String s2 = new String("d6gghj4jfsf"); //10
        System.out.println(compare(s1,s2));
    }
}