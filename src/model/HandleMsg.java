package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class HandleMsg{
	public void writefile(String filename,String s)throws IOException{
		
		filename="E:/chatmemory/"+filename+".txt";
		//filename��ҪΪ����·��
		File file=new File(filename);
		
		//������ļ������ڣ����½���txt�ļ����������¼sд��ȥ
		if(!file.exists()){
			System.out.println(filename+"������");
			if(file.createNewFile()){
				System.out.println("�ɹ��������ļ���");
			}
			else
				System.out.println("����"+filename+"�ļ�ʧ�ܣ�");
		}
		BufferedWriter output=new BufferedWriter(new FileWriter(filename));
		output.write(s);
		output.close();
		System.out.println("�����Ѿ��ɹ�д��"+filename+"�ļ���");
	}
	
	public boolean delFile(String filename){
		
		filename="E:/chatmemory/"+filename+".txt";
		File f=new File(filename);
		if(!f.exists()){
			System.out.println("���ļ������ڣ�ɾ��ʧ�ܣ�");
			return false;
		}
		if(!f.delete())
			return false;
		System.out.println("�ɹ�ɾ����");
		return true;
	}
}
