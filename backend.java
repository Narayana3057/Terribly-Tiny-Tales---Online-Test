package Mypackage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mypackage.HelloWorld.PairComparator;
import javafx.util.Pair;

/**
 * Servlet implementation class backend
 */
@WebServlet("/backend")
public class backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public backend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String k=request.getParameter("input");
		int i= Integer.parseInt(k); //string to integer
		String s="";
		Scanner x=null;
                try{
			x=new Scanner(new File("C:/Users/Narayana/Desktop/test.txt")); //accessing text file data
			while(x.hasNext()){    //storing content of file word by word in string s    
       			s += x.next()+" ";
       			}
       		String[] words=s.split(" "); //to store each word in string[] words
  		Map<String, Integer> map = new HashMap();
     		for(String word : words){  //storing string as key and int as value(frequency)
         	map.put(word, map.getOrDefault(word,0)+1);
    		}
    		//create priority queue with a pair of word and it's freq.
		PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue(i, new PairComparator());
     		for(String key : map.keySet()){
         		pq.add(new Pair(key, map.get(key)));
    		 }
     		String h1="";
	 	if(i>428){
			 h1="ONLY 428 WORDS ARE AVAILABLE";
			i=428;
		 }
     		String title = "TOP "+i+" WORDS WITH FREQUENCES";
     		String docType =
        	"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
    		String style=" table { font-family: arial, sans-serif; border-collapse: collapse; width: 80%;}td,th {border: 1px solid #dddddd;padding: 8px;}tr:nth-child(even) {background-color: #dddddd;}";
     		out.println(docType +
        		"<html>\n" +
			"<head><title>" + "Result" + "</title><style>"+style+"</style></head>\n" +
        		"<body bgcolor = \"#fff\">\n" + "<h1 align = \"center\">"+h1+"</h1>"+
			"<h1 align = \"center\">" + title + "</h1>\n" +
			 "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
        		"<tr bgcolor = \"#949494\">\n" +
        		"<th align = \"center\">Rank</th>"+
          		 "<th align = \"center\">WORD</th>"+
           		"<th align = \"center\">FREQUENCY</th>\n"+
			"</tr>\n"
     			);
		int z=1;//for rank
	     while(i>0){  //printing one by one
         	Pair<String, Integer> pair = pq.poll();
         	out.print("<tr><td align = \"center\">" + z + "</td><td align = \"center\">" + pair.getKey() + "</td><td align = \"center\">"+pair.getValue()+"</td></tr>");
        	 i--;
        	 z++;
     	     }
     	    out.println("</table>\n</body></html>");
     }
     catch(Exception e){
       		out.println("Could not find file"); 
     }
}
	
static class PairComparator implements Comparator<Pair<String,Integer>>{ 
 	    public int compare(Pair<String,Integer> s1, Pair<String,Integer> s2) { 
 	        if (s1.getValue() == s2.getValue()) 
 	            return s1.getKey().compareTo(s2.getKey()); 
 	        else 
 	            return s2.getValue() - s1.getValue();
 	    }

     }
	

}
