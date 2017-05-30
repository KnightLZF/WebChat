package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class HandleMsg{
	public void writefile(String filename,String s)throws IOException{
		
		filename="E:/chatmemory/"+filename+".txt";
		//filename需要为绝对路径
		File file=new File(filename);
		
		//如果该文件不存在，则新建该txt文件并把聊天记录s写进去
		if(!file.exists()){
			System.out.println(filename+"不存在");
			if(file.createNewFile()){
				System.out.println("成功创建新文件！");
			}
			else
				System.out.println("创建"+filename+"文件失败！");
		}
		BufferedWriter output=new BufferedWriter(new FileWriter(filename));
		output.write(s);
		output.close();
		System.out.println("数据已经成功写入"+filename+"文件！");
	}
	
	public boolean delFile(String filename){
		
		filename="E:/chatmemory/"+filename+".txt";
		File f=new File(filename);
		if(!f.exists()){
			System.out.println("该文件不存在，删除失败！");
			return false;
		}
		if(!f.delete())
			return false;
		System.out.println("成功删除！");
		return true;
	}
}
