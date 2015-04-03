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

		Statement stat = connection.createStatement();
		ResultSet result = stat.executeQuery( "SELECT * FROM word_table WHERE word = '"+str+"'");
		ArrayList<Integer> url_id_list = new ArrayList<Integer>();
		ArrayList<MYURL> myURL_list = new ArrayList<MYURL>();
		while (result.next())
			url_id_list.add(result.getInt("url_id"));
		result.close();	
		
		for (int i : url_id_list) {
			ResultSet resultURL = stat.executeQuery("SELECT * FROM url_table WHERE url_id = '"+i+"'");
			if (resultURL.next()) {
				MYURL myURL = new MYURL(i, resultURL.getString("url"), resultURL.getString("url_description"), resultURL.getString("image"));
				myURL_list.add(myURL);
			}
			resultURL.close();
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