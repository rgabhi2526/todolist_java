package project;
import java.util.*;
import java.io.*;
import java.text.*;

// this is the source file of the to do list program implementing the to_list interface
public class src implements to_list 
{
    List<String> arr;// arraylist that would be containing the tasks 
    ArrayList<String> arr_time;//arraylist containing the time associated to the task 
    public src()
    {// constructor of the class 
        arr=new ArrayList<>();
        arr_time=new ArrayList<>();
    }
    public void add_task(String a,String b)
    {
        // a => Task % b => Time 
        String msg=a;
        try
        {
            //checks whether time string is in proper format , if not an excpetion is thrown 
        SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
        Date date = inputFormat.parse(b);
        String formattedTime = outputFormat.format(date);
        // if the String b was in proper format then only the tasks would be added to arraylist 
        arr.add(msg);
        arr_time.add(formattedTime);
        }
        catch(ParseException e)
        {
            System.out.println("Invlalid Time format");
        }
    }
    public void remove_task(int i)
    {
        // this methods accepts an int argument which is the index of the task 
        try {
            String temp= arr.remove(i);
            String temp_time =arr_time.remove(i);
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
            Date date = inputFormat.parse(temp_time);
            String formattedTime = outputFormat.format(date);// converts time into 12 hr format 
            System.out.println("Task Removed: "+temp+" at "+formattedTime);
        } catch (Exception e) {
            // if the index is out of bound an exception is thrown 
            System.err.println("Error :"+e );
        }
    }
    public void modify_task(int i,String a) // this method takes an int argument for index and another String argument to change the task 
    {
        try {
            arr.remove(i);
            arr.add(i,a);
        } catch (Exception e) {
            // if the index is out of bound an exception is thrown 
            System.err.println(e);
        }
    }
    public void modify_task(int i,String a,String b)// method overloading -> this method takes an int argument for index and another String argument to change the task 
                                                    // while the 2nd String argument is for changing the time 
    {
          try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
            Date date = inputFormat.parse(b);
            String formattedTime = outputFormat.format(date);
            //first the already assigned task at the task is removed and then the new task is placed in place of the deleted task
            arr.remove(i);
            arr_time.remove(i);
            arr.add(i,a);
            arr_time.add(i, formattedTime);
          } catch (Exception e) {
            // if the time format is wrong or the index is outofbound 
            System.err.println(e);
          }
    }

    public void print()
    {
        File currentDirectory = new File("to_list.txt");
        try{
        if(currentDirectory.createNewFile())
        {
            //file already doesn't exists 
            FileWriter writer =new FileWriter("to_list.txt");
            for(int i=0;i<arr.size();i++)
            {
                // prints in the file in the following format :
                // Task {i} : {Task}    Time : {Time}
                writer.write("Task "+(i+1)+":"+arr.get(i)+"\t\t"+"Time "+":"+arr_time.get(i));
            }
            writer.close();

        }
        else{
            //file already exists 
            FileWriter writer =new FileWriter("to_list.txt");
            for(int i=0;i<arr.size();i++)
            {
                // prints in the file in the following format :
                // Task {i} : {Task}    Time : {Time}
                writer.write("Task "+(i+1)+":"+arr.get(i)+"\t\t"+"Time "+":"+arr_time.get(i)+"\n");

            }
            writer.close();
        }
        
    }
    catch(Exception e)
    {
        // if an IOexception or Security Exception is thrown 
        e.printStackTrace();
    }
}
    public void display()
    {
        for(int i=0;i<arr.size();i++)
            {
                // prints in the file in the following format :
                // Task {i} : {Task}    Time : {Time}
                System.out.println("Task "+(i+1)+":"+arr.get(i)+"\t\t"+"Time "+":"+arr_time.get(i));
            }
    }
}
    
