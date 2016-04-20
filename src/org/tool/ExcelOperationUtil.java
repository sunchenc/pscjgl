package org.tool;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import org.model.TbStudent;
import org.model.TbTeacher;
import org.service.ClassService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExcelOperationUtil {
	public List<TbStudent>readExcelData(String filePath){
		List<TbStudent> list=new ArrayList<TbStudent>();
		try{
			File xlsFile=new File(filePath);
			FileInputStream fs=new FileInputStream(xlsFile);
			Workbook book=Workbook.getWorkbook(fs);
		//	Workbook book=Workbook.getWorkbook(xlsFile);
			Sheet sheet=book.getSheet(0);
			int rows=sheet.getRows();
			for(int i=0;i<rows;i++){
				TbStudent stu=new TbStudent();  //还是放循环内部？
			    String studentId=sheet.getCell(0,i).getContents();
			    if(studentId.isEmpty()){
			    	continue;
			    }
				String studentName=sheet.getCell(1,i).getContents();
				if(studentName.isEmpty()){
					continue;
				}
			//	Integer studentClass=Integer.parseInt(sheet.getCell(2,i).getContents());
				String className=sheet.getCell(2,i).getContents();
//				Float totalgrade=new Float(0);
//				if(sheet.getCell(3,i).getContents()==null){
//					totalgrade=new Float(0);
//				}
				Float totalgrade=new Float(0);
//				if(sheet.getCell(3,i).getContents()!=null){
//					totalgrade=Float.parseFloat(sheet.getCell(3,i).getContents());
//				}
//				if(sheet.getCell(0, i).getType()==CellType.NUMBER){
//					;
//				}
				stu.setStudentId(studentId);
			    stu.setStudentName(studentName);
			    
		  //  ApplicationContext ctx=new FileSystemXmlApplicationContext("http://localhost:8080/please/src/applicationContext.xml");
			    URL xmlpath = this.getClass().getClassLoader().getResource("applicationContext.xml"); 
		        ApplicationContext ctx=new FileSystemXmlApplicationContext(xmlpath.toString());
			 //   ApplicationContext ctx=new FileSystemXmlApplicationContext("E:/senior/java ee/work/please/src/applicationContext.xml");
			    ClassService cs=null;
			    cs=(ClassService) ctx.getBean("classService");
			//	stu.setTbclass(cs.getOneClass(studentClass));
			    if(cs.findClassByName(className)!=null)
			    { 
			    stu.setTbclass(cs.findClassByName(className));
				stu.setTotalGrade(totalgrade);
				list.add(stu);
			    }
			}
			book.close();
			fs.close();   //需要吗？
			return list;
		}catch(Exception e){
			System.out.print("异常"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public List<TbTeacher>readExcelTeacherData(String filePath){
		List<TbTeacher> list=new ArrayList<TbTeacher>();
		try{
			File xlsFile=new File(filePath);
			FileInputStream fs=new FileInputStream(xlsFile);
			Workbook book=Workbook.getWorkbook(fs);
			Sheet sheet=book.getSheet(0);
			int rows=sheet.getRows();
			for(int i=0;i<rows;i++){
				TbTeacher tt=new TbTeacher();  //还是放循环内部？
			    String teacherId=sheet.getCell(0,i).getContents();
			    if(teacherId.isEmpty()){
			    	continue;
			    }
				String teacherName=sheet.getCell(1,i).getContents();
				if(teacherName.isEmpty()){
					continue;
				}
				tt.setTeacherId(teacherId);
				tt.setTeacherName(teacherName);
			 	list.add(tt);
			}
			book.close();
			fs.close();  
			return list;
		}catch(Exception e){
			System.out.print("异常"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
