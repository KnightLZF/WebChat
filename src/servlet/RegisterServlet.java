package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tools.JDBConection;

public class RegisterServlet  extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		this.doPost(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		String message="";//��ʾ������Ϣ
		boolean t=false;//�ж��û��Ƿ�ע��ɹ�
		
		/*��ȡ�û��ύ�ı���Ϣ*/
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String passwords=req.getParameter("passwords");
		
		String sex=req.getParameter("sex");
	    String ages=req.getParameter("ages");
		int age=Integer.parseInt(ages);

		
		/*��� �û��ύ�ı���Ϣ����һ��Ϊ�գ��򷵻ش�����Ϣ��ע��ʧ�ܣ�*/
		if(username.equals("")||password.equals("")||passwords.equals("")||ages.equals(""))
			message="����һ�����Ϊ�գ���ѱ���Ϣ��д������";
		//����
		else{
			
			//����������120�����С��0��
			if(age<0||age>120)
				message="����ֻ��Ϊ0-120֮���������";

			else{
			//�������ݿ�����
			JDBConection con=new JDBConection();
			if(con.createConnection()){
				
				/*����û����Ѵ��ڣ�ע��ʧ�ܣ�*/
				String sql="select * from user where username='"+username+"';";
				ResultSet rs=con.executeQuery(sql);
				try{if(rs.next())
					message="���û����Ѵ��ڣ�ע��ʧ�ܣ�";
				//����
				else{
					//���������ȷ�����벻ͬ��ע��ʧ�ܣ�*/
					if(!password.equals(passwords))
						message="������ȷ�����벻ͬ���������趨����ע�ᣡ";
					//����ע��ɹ�
					else{
						message="ע��ɹ������¼��";
						String sqls="insert into user values('"+username+"','"+password+"');";
						String sqls2="insert into user_impression values('"+username+"');";
						
						//���sexΪ0��˵��ѡ������������˵��ѡ��Ů��
						if(sex.equals("0")) sex="M";
						else sex="F";
						
						//�����û���Ϣ��
						String sql3="insert into userinfo values('"+username+"','"+sex+"','"+age+"');";
						
						con.executeUpdate(sqls);
						con.executeUpdate(sqls2);
						con.executeUpdate(sql3);
						t=true;
					}
				}
				}catch(SQLException e){e.printStackTrace();}
				con.closeResultSet(rs);
				con.closeConnection();
			}
			}
		}
		//���ע��ʧ�ܣ�����ע��ҳ��
		if(!t){
		req.setAttribute("registerfail", message);
		req.getRequestDispatcher("register.jsp").forward(req, resp);}
		else{
			req.setAttribute("registersuccess", message);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
