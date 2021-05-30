import java.util.ArrayList;

public class Class implements teacher{
    String id;//課號
    int credit;//學分
    String ChineseName;//中文課名
    boolean compulsory;
    ArrayList<Integer> classTime=new ArrayList<Integer>();
    public Class(String id,String ChineseName,boolean compulsory,String teacherName,String teacherPhoto,int args[]){
        this.id=id;
        for (int arg:args)
            classTime.add(arg);
        //幾堂課幾學分
        this.credit=classTime.size();
        teacherName=teacherName;
        teacherPhoto=teacherPhoto;
        this.compulsory=compulsory;
    }
    public Class(String id,int credit,String ChineseName,boolean compulsory,String teacherName,String teacherPhoto,int args[]){
        this(id,ChineseName,compulsory,teacherName,teacherPhoto,args);
        this.credit=credit;
    }

}
