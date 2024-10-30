package project;
import java.util.*;
import java.io.*;
import java.text.*;


public class src implements to_list 
{
    List<String> arr;
    ArrayList<String> arr_time;
    public src()
    {
        arr=new ArrayList<>();
        arr_time=new ArrayList<>();
    }
    public void add_task(String a,String b)
    {
        String msg=a;
        try
        {
        SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
        Date date = inputFormat.parse(b);
        String formattedTime = outputFormat.format(date);
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
        try {
            String temp= arr.remove(i);
            String temp_time =arr_time.remove(i);
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
            Date date = inputFormat.parse(temp_time);
            String formattedTime = outputFormat.format(date);
            System.out.println("Task Removed: "+temp+" at "+formattedTime);
            System.out.println("Task successfully removed !!");
        } catch (Exception e) {
            System.err.println("Error :"+e );
        }
    }
    public void modify_task(int i,String a)
    {
        try {
            arr.remove(i);
            arr.add(i,a);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void modify_task(int i,String a,String b)
    {
          try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a");
            Date date = inputFormat.parse(b);
            String formattedTime = outputFormat.format(date);
            arr.remove(i);
            arr_time.remove(i);
            arr.add(i,a);
            arr_time.add(i, formattedTime);
          } catch (Exception e) {
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
            writer.write("Task\t\tTime");
            for(int i=0;i<arr.size();i++)
            {
                writer.write(arr.get(i)+"\t\t"+arr_time.get(i));
            }
            writer.close();

        }
        else{
            //file already exists 
            FileWriter writer =new FileWriter("to_list.txt");
            writer.write("Task\t\tTime");
            for(int i=0;i<arr.size();i++)
            {
                writer.write(arr.get(i)+"\t\t"+arr_time.get(i)+"\n");

            }
            writer.close();
        }
        
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}
    public void display()
    {
        System.out.print("Task\t\tTime");
        for(int i=0;i<arr.size();i++)
            {
                System.out.print(arr.get(i)+"\t\t"+arr_time.get(i)+"\n");
            }
    }
}
    
