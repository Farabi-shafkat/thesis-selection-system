/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisselectionsystem;

/**
 *
 * @author HP
 */
public class ThesisSelectionSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Supervisor sp1 = new Supervisor("professor", "moriarty", "CSE");
        Supervisor sp3 = new Supervisor("professor", "sherlock", "EEE");
        Supervisor sp2 = new Supervisor("professor", "mama", "CSE");
        Student st1 = new Student("ferb", "cse", "4th", "2016", 3, "3.35");

        Student st2 = new Student("ferb1", "cse", "4th", "2016", 4, "3.44");
        Student st3 = new Student("ferb2", "cse", "4th", "2016", 5, "3.22");
        Student st4 = new Student("ferb3", "cse", "4th", "2016", 0, "3.88");
        Student st5 = new Student("ferb4", "cse", "4th", "2016", 1, "3.96");
        Student st6 = new Student("ferb5", "cse", "4th", "2016", 2, "3.32");
        Student[] st = new Student[6];

        topic_list list = new topic_list();
        Thesis_topic.list_pointer = list;
        sp1.create_thesis_topic("artificial intelligence");
        sp1.create_thesis_topic("creating computer overlords");
        sp2.create_thesis_topic("data mining");
        sp3.create_thesis_topic("neural network");
        st1.give_preference(0);
        st1.give_preference(1);
        st1.give_preference(2);
        st1.give_preference(3);

        st2.give_preference(3);
        st2.give_preference(1);
        st2.give_preference(2);
        st2.give_preference(0);

        st3.give_preference(1);
        st3.give_preference(2);
        st3.give_preference(3);
        st3.give_preference(0);

        st4.give_preference(2);
        st4.give_preference(3);
        st4.give_preference(1);
        st4.give_preference(0);

        st5.give_preference(1);
        st5.give_preference(2);
        st5.give_preference(3);
        st5.give_preference(0);

        st6.give_preference(2);
        st6.give_preference(3);
        st6.give_preference(1);
        st6.give_preference(0);

        st[0] = st1;
        st[1] = st2;
        st[2] = st3;
        st[3] = st4;
        st[4] = st5;
        st[5] = st6;
        list.assign_students(st);
        for (int i = 0; i < st.length; i++) {
            System.out.println(st[i].getStudent_id() + " " + st[i].getUserName() + " " + st[i].getCGPA() + " " + st[i].getAssigned_project());
        }*/
        //Supervisor sp1=new Supervisor();
        //sp1.setSupervisor_id(13123);
        //System.out.println(sp1.getSupervisor_id());
        db_extract db=new db_extract();
        Student[] st=db.get_student();
        Supervisor[] sp=db.get_supervisor();
    //    System.out.println(sp[0].getSupervisor_id());
        for(int i=0;i<sp.length;i++)
        {   
            if(sp[i]!=null)
                db.assign_projects(sp,i);
        }
        topic_list tp=db.get_topic_list();
        
        tp.assign_students(st);
       // st[0].getAssigned_project();
        db.modify(st,sp,tp);
    }

}
