package employeemanagementsystem;
import java.io.*;
import java.util.*;
public class Update {
    public void update(int idtofind, String newname, int newage, long newsalary) {
        try {
            File inputFile = new File("resources/EmployeeData.txt");
            File tempFile = new File("resources/temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            //System.out.println("Reading data from the file...");
            boolean updated = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id;
                try {
                    id = Integer.parseInt(data[0]);
                } catch (NumberFormatException e) {
                    continue;
                }
                //System.out.println("Reading line: " + line);

                if (id==idtofind) {
                    line = idtofind + "," + newname + "," + newage + "," + newsalary;
                    updated = true;
                    System.out.println("Record updated: " + line);
                }
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
            if (inputFile.delete()) {
                //System.out.println("Original file deleted successfully.");
                if (tempFile.renameTo(inputFile)) {
                    //System.out.println("Temp file renamed to original file.");
                } else {
                    System.out.println("Error while renaming the temp file.");
                }
            } else {
                System.out.println("Error deleting the original file.");
            }

            if (!updated) {
                System.out.println("Record not found for update: " + idtofind);
            }

           //System.out.println("Record updated successfully: " + idtofind);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
    	   Scanner sc = new Scanner(System.in);
           System.out.println("Enter the employee ID you want to update:");
           int idtofind = sc.nextInt();
           sc.nextLine(); 

           System.out.println("Enter the new name:");
           String newname = sc.nextLine();

           System.out.println("Enter the new age:");
           int newage = sc.nextInt();

           System.out.println("Enter the new salary:");
           long newsalary = sc.nextLong();

           Update u = new Update();
           u.update(idtofind, newname, newage, newsalary);

           sc.close();
       }
    }