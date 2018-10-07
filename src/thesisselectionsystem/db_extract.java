/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisselectionsystem;
import java.sql.*;
/**
 *
 * @author HP
 */
public class  db_extract {
    static String DB_URL = "jdbc:oracle:thin:@localhost:1522:orcl";//ei address kaj na korle call me zahid"
    static Connection con=null;
    static Statement stat=null;
    static ResultSet result=null;
    public static Supervisor[] get_supervisor()
    {
        Supervisor sp_arr[]=null;
        try{
            
       
            con=DriverManager.getConnection(DB_URL,"thesis_system","1234");
            stat=con.createStatement();
            
            String qr="select count(*) from supervisor";
            result=stat.executeQuery(qr);
            result.next();
            int row_num=result.getInt(1);
            sp_arr=new Supervisor[row_num];
            qr="select * from Supervisor";
            result=stat.executeQuery(qr);
            int cnt=0;
            ResultSetMetaData metadata=result.getMetaData();
            int col_num=metadata.getColumnCount();
            while(result.next())
            {
                sp_arr[cnt].setSupervisor_id(result.getInt(1));
                sp_arr[cnt].setUserName(result.getString(3));
                sp_arr[cnt].setDepartment(result.getString(4));
                sp_arr[cnt].setSupervisor_rank(result.getString(5));
                
                String qr2="select thesis_topic.id from thesis_topic,supervisor where thesis_topic.supervisor=supervisor.id";
                String qr3="select count(*) from ("+qr2+")";
                ResultSet res2=stat.executeQuery(qr3);
                res2.next();
                int row_num1=res2.getInt(1);
                int pr[]= new int[row_num];
                res2=stat.executeQuery(qr2);
                int cn=0;
                while(res2.next())
                {
                    pr[cn++]=res2.getInt(1);
                    cn++;
                }
                sp_arr[cnt].setSupervising_projects(pr);
                cnt++;
            }
           
            
           // metadata=result.getMetaData();
          
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                //result.close();
                stat.close();
                con.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return sp_arr;
    }
    
    public static Student[] get_student()
    {
        Student st_arr[]=null;
        try{
            
       
            con=DriverManager.getConnection(DB_URL,"thesis_system","1234");
            stat=con.createStatement();
            
            String qr="select count(*) from student";
            result=stat.executeQuery(qr);
            result.next();
            int row_num=result.getInt(1);
            st_arr=new Student[row_num];
            qr="select * from Student";
            result=stat.executeQuery(qr);
            int cnt=0;
            ResultSetMetaData metadata=result.getMetaData();
            int col_num=metadata.getColumnCount();
            while(result.next())
            {
                st_arr[cnt].setStudent_id(result.getInt(1));
                st_arr[cnt].setUserName(result.getString(3));
                st_arr[cnt].setDepartment(result.getString(4));
                st_arr[cnt].setPartner_id(result.getInt(5));
                st_arr[cnt].setCGPA(result.getString(6));
                st_arr[cnt].setAssigned_project(result.getInt(7));
                st_arr[cnt].give_preference(result.getInt(8));
                st_arr[cnt].give_preference(result.getInt(9));
                st_arr[cnt].give_preference(result.getInt(10));
                st_arr[cnt].give_preference(result.getInt(11));
                cnt++;
            }
           
            
           // metadata=result.getMetaData();
          
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                //result.close();
                stat.close();
                con.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return st_arr;
    }
    
    
    public static topic_list get_topic_list()
    {
        topic_list topic=null;
        try{
            
       
            con=DriverManager.getConnection(DB_URL,"thesis_system","1234");
            stat=con.createStatement();
            
            String qr="select count(*) from thesis_topic";
            result=stat.executeQuery(qr);
            result.next();
            int row_num=result.getInt(1);
            topic=new topic_list(row_num);
            qr="select * from thesis_topic";
            result=stat.executeQuery(qr);
            int cnt=0;
            ResultSetMetaData metadata=result.getMetaData();
            int col_num=metadata.getColumnCount();
            while(result.next())
            {
                Thesis_topic ths=new Thesis_topic();
                ths.setThesis_id(result.getInt(1));
                ths.setSupervisor(result.getInt(2));
                ths.setDepartment(result.getString(3));
                ths.setDescription(result.getString(4));
              //  if(result.getInt(5)==null)
                int as[]=new int[2];
                as[0]=result.getInt(5);
                boolean a=true;
                boolean b=true;
                if(result.wasNull()==true)
                {
                    a=false;
                }
                as[0]=result.getInt(6);
                if(result.wasNull()==true)
                {
                    b=false;
                }
                if(a&&b)
                    ths.setAssigned_Students(as);
                topic.add(ths);
                cnt++;
            }
           
            
           // metadata=result.getMetaData();
          
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                //result.close();
                stat.close();
                con.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return topic;
    }
    
}