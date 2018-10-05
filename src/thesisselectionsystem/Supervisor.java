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
public class Supervisor extends User {

    private int Supervisor_id;
    private static int cnt = 0;
    private String supervisor_rank;
    private Thesis_topic[] supervising_projects;

    //private int affiliated_Student_id[][];
    public Supervisor(String rank, String name, String Department) {
        super(name, Department);
        cnt++;
        Supervisor_id = cnt;
        supervisor_rank = rank;

    }

    /**
     * @return the Supervisor_id
     */
    public int getSupervisor_id() {
        return Supervisor_id;
    }

    /**
     * @param Supervisor_id the Supervisor_id to set
     */
    public void setSupervisor_id(int Supervisor_id) {
        this.Supervisor_id = Supervisor_id;
    }

    /**
     * @return the proposed_project_id
     */
    /**
     * @return the supervisor_rank
     */
    public String getSupervisor_rank() {
        return supervisor_rank;
    }

    /**
     * @param supervisor_rank the supervisor_rank to set
     */
    public void setSupervisor_rank(String supervisor_rank) {
        this.supervisor_rank = supervisor_rank;
    }

    //this creates a thesis topic,updates the thesis topics_list;
    public void create_thesis_topic(String desc) {
        //    String desc;
        Thesis_topic topic = new Thesis_topic(Department, desc);
        topic.setSupervisor(this);
       
        if (supervising_projects != null) {
             Thesis_topic[] proj;
            int l = supervising_projects.length;
            proj = new Thesis_topic[l + 1];
            for (int i = 0; i < l; i++) {
                proj[i] = supervising_projects[i];

            }
            proj[l] = topic;
            supervising_projects = proj;
        }
        else
        {
            supervising_projects=new Thesis_topic[1];
            supervising_projects[0]=topic;
        }

    }

}
