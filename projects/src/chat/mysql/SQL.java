package chat.mysql;

public class SQL {

	private ForDataBase db;
	
	public SQL(String address){
		db = new ForDataBase(address);
	}
	
	public boolean insertUser(String name, String password) {
		if(isTaken(name))
			return false;
		else {
			db.insertUpdateDelete("insert into chat values('" + name + "', '" + password + "', false);");
			return true;
		}
	}
	
	public boolean isTaken(String name) {
		String[][] result = db.select("select * from chat where binary name='" + name + "';");
		if(result.length > 0)
			return true;
		else
			return false;
	}
	
	public void updateUser(String name, String field, String newVal) {
		if(!field.equals("admin"))
			newVal = "'" + newVal + "'";
		
		if(isTaken(name))
			db.insertUpdateDelete("update chat set " + field + "=" + newVal + " where binary name='" + name + "';");
	}
	
	public void deleteUser(String name) {
		if(isTaken(name))
			db.insertUpdateDelete("delete from chat where binary name='" + name + "';");
	}
	
	public String getPassword(String name) {
		String[][] result = db.select("select password from chat where binary name='" + name + "';");
		
		if(result.length > 0)
			return result[0][0];
		else
			return "";
	}
	
	public boolean isAdmin(String name) {
		String[][] result = db.select("select admin from chat where binary name='" + name + "';");
		
		if(result.length > 0 && result[0][0].equals("1"))
			return true;
		else
			return false;
	}
}
