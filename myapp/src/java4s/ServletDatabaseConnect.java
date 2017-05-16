package java4s;
 
import java.io.IOException;

import java.io.PrintWriter;

import java.sql.*;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ServletDatabaseConnect extends HttpServlet  
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");        
        String state=req.getParameter("searchval");    
        System.out.println("state :"+state);
        try
        {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
             PreparedStatement ps=con.prepareStatement("select * from SearchQuery where upper(query) like upper('%"+state+"%')");
             
             System.out.println("connection established successfully...!!");     
 
             ResultSet rs=ps.executeQuery();
 
             
             
             
                 if(rs.next())
                 {
                	 pw.println("Query Searched:"+state+".   The following links may help you.<br> <br>");
                	  pw.println("<br> <br><html><head><title>search Result</title></head><body><a href="+rs.getString(2)+">"+rs.getString(2)+"</a></body></html>");
                	  pw.println("<br> <br><html><head><title>search Result</title></head><body><a href="+rs.getString(3)+">"+rs.getString(3)+"</a></body></html>");
                	  pw.println("<br> <br><html><head><title>search Result</title></head><body><a href="+rs.getString(4)+">"+rs.getString(4)+"</a></body></html>");
                 }
                 else
                 {
                	 PreparedStatement ps1=con.prepareStatement("insert into SearchQuery (query,result,result2,result3) values('"+state+"','your query has been posted and we will get with your answer soon',' ',' ')");
                	  ResultSet rs1=ps1.executeQuery();
                	 if(rs1.next())
                	 {
                		 pw.println("<html><head><title></title></head><body>no result found :( <br>try again later</body></html>");
                		
                	 }
                 }
                 
             pw.println("</table>");
             pw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
 
    }
}
