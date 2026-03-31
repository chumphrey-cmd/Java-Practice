public class Main {

    public static void main (String[] args){

        Employee[] arr = {
                new Employee("Bob", 23),
                new Employee("Sally", 18),
                new Employee("Frank", 33),
                new Employee("Joan", 28)
        };

        Integer [] arr2 = {1,20, 9, 3, 12, 35, 10, -12};
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println("Quick sort of Integers: ");
        for (Integer i : arr2)
            System.out.println(i);

        quickSort(arr, 0, arr.length - 1);
        System.out.println("Quick sort on ages from Employee Class: ");
        for (Employee e : arr)
            System.out.println(e);

    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high){
        if (low >= high){
            return;
        }

        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high){

        /// Generic implementation
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j<= high - 1; j++){

            /// Modify the comparison here to sort from largest to smallest (>) or smallest to largest (<)
            if(arr[j].compareTo(pivot) < 0){
                i++;

                /// Generic implementation
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        /// Generic implementation
        T temp2 = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp2;

        return i + 1;

    }

}

/// Employee Class
public class Employee implements Comparable<Employee> {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int compareTo(Employee obj){
        return age - obj.age;
    }
}