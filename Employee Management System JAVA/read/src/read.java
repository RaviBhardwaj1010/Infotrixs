package employeemanagementsystem;

import java.io.*;
public class Read {
    private static final String filepath = "resources/EmployeeData.txt";

    public void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                	int id= Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    int salary = Integer.parseInt(data[3]);
                    System.out.println("EmpId: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary);}
        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Read r = new Read();
        r.read();
    }
}
