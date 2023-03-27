import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    String gender;
    int age;
    String classroom;
    float score;
    Student(){}
    Student(int id, String name, String gender, int age, String classroom, float score){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classroom = classroom;
        this.score = score;
    }
    void printOutputInfo(){
        System.out.println("--------------------------------------------");
        System.out.println(" ID : "+id);
        System.out.println(" Name : "+name);
        System.out.println(" Gender : "+gender);
        System.out.println(" Age : "+age);
        System.out.println(" Classroom : "+classroom);
        System.out.println(" Score : "+score);
    }
    void printInputInfo(Scanner input) {
        boolean isIDValid = false;
        do {
            String studentId;
            System.out.println("Enter ID : ");
            try {
                studentId = input.next();
                id = Integer.parseInt(studentId);
                isIDValid = true;
            } catch (Exception x) {
                System.out.println(" Invalid ID format!! (Integer only! )");
            }
        } while (!isIDValid);

        System.out.println("Enter Name : ");
        input.nextLine();
        name = input.nextLine();
        System.out.println("Enter Gender : ");
        gender = input.nextLine();
        System.out.println("Enter Age : ");
        age = input.nextInt();
        System.out.println("Enter Classroom : ");
        classroom = input.next();
        System.out.println(" Enter Score : ");
        score = input.nextFloat();
    }
}
public class Main {
        static void pressEnterKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ======================== Press Enter to Continue ========================");
        scanner.nextLine();
        }
        public static void main(String[] args) {
            ArrayList<Student> stu = new ArrayList<>();
            Scanner input = new Scanner(System.in);
            int Option = 0;
            do {
                System.out.println("*********<-> Welcome to Student Management <->*********");
                System.out.println(" [1]. Insert Student to System ");
                System.out.println(" [2]. Edit Student Information ");
                System.out.println(" [3]. Search Student Information ");
                System.out.println(" [4]. Delete Student Information ");
                System.out.println(" [5]. Show Student Information ");
                System.out.println(" [6]. Exit ");
                System.out.println(" => Please select  option from 1 to 6 : ");
                String option = input.nextLine();
                try {
                    Option = Integer.parseInt(option);
                } catch (Exception x) {
                    Option = 0;
                    System.out.println("--------- Invalid Input number ! ---------");
                }

                switch (Option) {
                    case 1: {
                        System.out.println("===========================================");
                        System.out.println("--------------- Insert Student ------------");
                        Student newStudent = new Student();
                        newStudent.printInputInfo(input);
                        stu.add(newStudent);
                        System.out.println(" You have insert successfully !");
                        input.nextLine();
                    }
                    case 2: {
                        boolean edit=false;
                        System.out.println("===========================================");
                        System.out.println("--------------- Edit Student --------------");
                        System.out.println("Please enter id :");
                        int EditId = input.nextInt();
                        if (stu.size()>0){
                            for (Student student:stu){
                                if (student.id == EditId){
                                    System.out.println("Enter the new ID :");
                                    student.id=input.nextInt();
                                    System.out.println("Enter the new Name :");
                                    input.nextLine();
                                    student.name = input.nextLine();
                                    System.out.println("Enter the new Gender :");
                                    student.gender= input.nextLine();
                                    System.out.println("Enter the new Classroom :");
                                    student.classroom = input.next();
                                    edit=true;
                                }
                            }
                        }
                        if (!edit){
                            System.out.println(" Id not font for Update!!");
                        }
                        break;
                    }
                    case 3: {
                        int searchOption;
                        System.out.println("===========================================");
                        System.out.println("--------------- Search Student ------------");
                        System.out.println(" [1]. Search By ID  ");
                        System.out.println(" [2]. Search By Name  ");
                        System.out.println(" [3]. Exit ");
                        System.out.println("=> Please choose option from 1 to 3 : ");
                        searchOption = input.nextInt();
                        switch (searchOption) {
                            case 1: {
                                int searchId;
                                boolean isStudentInvalid = false;
                                System.out.println("--------------- Search By ID -------------");
                                System.out.println(" Enter id to search : ");
                                searchId = input.nextInt();
                                for (int i = 0; i < stu.size(); i++) {
                                    if (searchId == stu.get(i).id) {
                                        // worker exist
                                        isStudentInvalid = true;
                                        stu.get(i).printOutputInfo();
                                    }
                                }
                                if (!isStudentInvalid) {
                                    System.out.println("Student with ID = " + searchId + " doesn't exist !!!");
                                }
                                pressEnterKey();
                                break;
                            }
                            case 2:{
                                boolean user = false;
                                System.out.println("--------------- Search By Name ---------------");
                                String searchName ;
                                System.out.println("Enter name to search : ");input.nextLine();
                                searchName = input.nextLine();

                                for(int i =0; i < stu.size(); i++){
                                    if(searchName.equals(stu.get(i).name)){
                                        // user exist
                                        user = true;
                                        stu.get(i).printOutputInfo();
                                    }
                                }
                                if(!user) {
                                    System.out.println("Student with ID = " + searchName + " doesn't exist !!!");
                                }
                            input.nextLine();
                            break;
                            }
                            case 3:{
                                System.exit(0);
                            }
                        }
                    }
                    case 4:{
                        boolean isFount =false;
                        System.out.println("===========================================");
                        System.out.println("--------------- Delete StudentInfo ------------");
                        System.out.println("Enter ID Student for delete :");
                        int delete = input.nextInt();
                        System.out.println(delete);
                        for (int i = 0; i<stu.size();i++){
                            if (stu.get(i).id==delete){
                                stu.remove(i);
                                isFount=true;
                            }
                        }
                        if (!isFount){
                            System.out.println("ID id not fount!!");
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("===========================================");
                        System.out.println("------------- Show StudentInfo ------------");
                        for (int j = 0; j < stu.size(); j++) {
                            stu.get(j).printOutputInfo();
                        }
                        break;
                    }
                    case 6:{
                        System.exit(0);
                    }
                }
            } while ((Option !=6));
        }      }