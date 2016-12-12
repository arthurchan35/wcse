<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="cs390.MYURL"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!

	public static Properties readProperties(String path) throws IOException {
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(path);
		props.load(in);
		in.close();
		return props;
	}
	
	public static Connection getConnection(Properties props) throws SQLException, IOException {
		String drivers = props.getProperty("jdbc.drivers");
		
		if (drivers != null) 
			System.setProperty("jdbc.drivers", drivers);

		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		return DriverManager.getConnection( url, username, password);	
	}	


	public static ArrayList<MYURL> getURL (Connection connection, String str) throws SQLException, IOException {
		String parts[] = str.split(" ");
		int size = parts.length;
		Statement stat = connection.createStatement();
		/*ResultSet result = stat.executeQuery( "SELECT * FROM word_table WHERE word = '"+str+"'");
		ArrayList<Integer> url_id_list = new ArrayList<Integer>();
		ArrayList<MYURL> myURL_list = new ArrayList<MYURL>();
		while (result.next())
			url_id_list.add(result.getInt("url_id"));
		result.close();	
		
		for (int i : url_id_list) {
			ResultSet resultURL = stat.executeQuery("SELECT * FROM url_table WHERE url_id = '"+i+"'");
			if (resultURL.next()) {
				MYURL myURL = new MYURL(i, resultURL.getString("url"), 
				resultURL.getString("url_description"), resultURL.getString("image"));
				myURL_list.add(myURL);
			}
			resultURL.close();
		}*/
		Hashtable<Integer, Integer> myHT = new Hashtable<Integer, Integer>();
		ResultSet result0 = stat.executeQuery( "SELECT * FROM word_table WHERE word = '"+parts[0]+"'");
		ArrayList<Integer> url_id_list0 = new ArrayList<Integer>();

		ArrayList<MYURL> myURL_list = new ArrayList<MYURL>();
		while (result0.next())
			url_id_list0.add(result0.getInt("url_id"));
		result0.close();	
		
		for (int i : url_id_list0) {
			if (myHT.containsKey(i)) {
				int occurence = myHT.get(i);
				myHT.put(i, occurence + 1);
			}
			else myHT.put(i, 1);
		}

		if (size == 1) {
			for (int i : myHT.keySet()) {
				ResultSet resultURL = stat.executeQuery("SELECT * FROM url_table WHERE url_id = '"+i+"'");
				if (resultURL.next()) {
					MYURL myURL = new MYURL(i, resultURL.getString("url"), 
					resultURL.getString("url_description"), resultURL.getString("image"));
					myURL_list.add(myURL);
				}
				resultURL.close();
			}
		}
		else {
			stat = connection.createStatement();
			ResultSet result1 = stat.executeQuery( "SELECT * FROM word_table WHERE word = '"+parts[1]+"'");
			ArrayList<Integer> url_id_list1 = new ArrayList<Integer>();
			ArrayList<MYURL> myURL_list1 = new ArrayList<MYURL>();
			while (result1.next())
				url_id_list1.add(result1.getInt("url_id"));
			result1.close();	
			for (int i : url_id_list1) {
				if (myHT.containsKey(i)) {
					int occurence = myHT.get(i);
					myHT.put(i, occurence + 1);
				}
				else myHT.put(i, 1);
			}
			for (int i : myHT.keySet()) {
				if (myHT.get(i) < 2) continue;
				ResultSet resultURL = stat.executeQuery("SELECT * FROM url_table WHERE url_id = '"+i+"'");
				if (resultURL.next()) {
					MYURL myURL = new MYURL(i, resultURL.getString("url"), 
					resultURL.getString("url_description"), resultURL.getString("image"));
					myURL_list.add(myURL);
				}
				resultURL.close();
			}	
			stat.close();
		}
		return myURL_list;

	}

%>



 <html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CS390</title>
</head>

<body>
    <form id="searchForm" form action = "search.jsp" method="post">

		<fieldset>
        
           	<input id="s" type="text" name = "keyWords" />
            
            <input type="submit" value="Submit" id="submitButton" />
            
            <div id="searchInContainer">
                <input type="radio" name="check" value="site" id="searchSite" checked />
                <label for="searchSite" id="siteNameLabel">Search</label>
                
                <input type="radio" name="check" value="web" id="searchWeb" />
                <label for="searchWeb">Search The Web</label>
			</div>
                        
            <ul class="icons">
                <li class="web" title="Web Search" data-searchType="web">Web</li>
                <li class="images" title="Image Search" data-searchType="images">Images</li>
                <li class="news" title="News Search" data-searchType="news">News</li>
                <li class="videos" title="Video Search" data-searchType="video">Videos</li>
            </ul>
            
        </fieldset>
    </form>
<%
	String keyWords = request.getParameter("keyWords");
	Properties props = null;
	Connection connection = null;
	try {props = readProperties("database.properties");}
	catch (Exception e) {throw new Error(e);}
	try {connection = getConnection(props);}
	catch (Exception e) {throw new Error(e);}
	ArrayList<MYURL> myURL_list = getURL(connection, keyWords);
	for (MYURL myURL: myURL_list) {
		out.println(myURL.url_id + "<br>");
		out.println("<image src=\"" + myURL.image + "\"><br>");
		out.println("<a href=\"" + myURL.url + "\"target=\"blank\">" + myURL.url + "</a><br>");
		out.println(myURL.url_description + "<br><br><br><br>");
	}
	connection.close();
%>


</body>


</html>