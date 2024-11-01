package project;
// declearing the interface and the Methods the ToDoList contains 
interface to_list {
    void add_task(String a,String b);// a refers to the task while b refers to the time string 
    void remove_task(int i);
    void modify_task(int i,String a);
    void print();// prints the task into a txt file 
}

