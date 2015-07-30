

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")		//url of the servlet
@MultipartConfig
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /*
     * (non-Javadoc)
     * doGet() has been used for getting the language for an entered phrase
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");	//setting to UTF-8 to support all languages
		PrintWriter out = response.getWriter();
		String phrase = request.getParameter("phrase");		//obtaining the entered text from user
		String dets=AcceptInp.phraselang(phrase);			//getting result after processing from AcceptInp class
	    int totcount=AcceptInp.count2(phrase);				//getting total number of characters in text
		int maxcount=0;
		String maxcountlang="";
		out.println("Entered Phrase : <br>"+phrase+"<br>");
		StringTokenizer st = new StringTokenizer(dets);
		while(st.hasMoreElements()){
			String langname = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			if(maxcount<=count)								//to detect the language of the phrase
			{
				maxcount=count;				// basically the language with highest content in the phrase is stored along with the count
				maxcountlang=langname;
			}
			float pert=((float)count/totcount)*100;			//percentage calculation
			out.println("<br>");
			out.println("Language : "+langname+"<br>");			//printing language percentage details
			out.println("Total Count : "+pert+"%<br>");
		}
		out.println("<br>This phrase is in "+maxcountlang+"<br>");		//phrase language verdict printing
		out.println("<a href=\"http://localhost:7667/PropUplLangDet\">Click to test again</a>");	//returning to the home page
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\    
		response.setContentType("text/html; charset=UTF-8");
	    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = filePart.getSubmittedFileName();	//gets the name of the file uploaded
	    PrintWriter out = response.getWriter();
	    out.println("Entered File's Name : "+fileName);		//printing file name 
	    int totcount=AcceptInp.count1(filePart);	//total character count in the file
	    String dets=AcceptInp.stats(filePart);//getting stats of the uploaded file
		StringTokenizer st = new StringTokenizer(dets);
		int maxcount=0;
		String maxcountlang="";
		while(st.hasMoreElements()){
			String langname = st.nextToken();		//stores the language name from the stats returned
			int count = Integer.parseInt(st.nextToken());	//stores the character count from the stats returned
			if(maxcount<=count)						//to detect the language of the file
			{
				maxcount=count;		// basically the language with highest content in the phrase is stored along with the count
				maxcountlang=langname;
			}
			float pert=((float)count/totcount)*100;		//percentage calculation
			out.println("<br>");					//printing language percentage details
			out.println("Language : "+langname+"<br>");
			out.println("Total Count : "+pert+"%<br>");
		}
		out.println("<br>This is a "+maxcountlang+" file.<br>");	//file's language verdict 
		out.println("<a href=\"http://localhost:7667/PropUplLangDet\">Click to test again</a>");	//returning to the home page

	}

}
