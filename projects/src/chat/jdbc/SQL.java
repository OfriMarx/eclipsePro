package chat.jdbc;

public class SQL {

	private static ForDataBase db = new ForDataBase();
	
	
	public static boolean insertUser(String name, String password) {
		if(isTaken(name))
			return false;
		else {
			db.insertUpdateDelete("insert into chat values('" + name + "', '" + password + "', false);");
			return true;
		}
	}
	
	public static boolean isTaken(String name) {
		String[][] result = db.select("select * from chat where name='" + name + "';");
		if(result.length > 0)
			return true;
		else
			return false;
	}
	
	public static void updateUser(String name, String field, String newVal) {
		if(!field.equals("admin"))
			newVal = "'" + newVal + "'";
		
		if(isTaken(name))
			db.insertUpdateDelete("update chat set " + field + "=" + newVal + " where name='" + name + "';");
	}
	
	public static void deleteUser(String name) {
		if(isTaken(name))
			db.insertUpdateDelete("delete from chat where name='" + name + "';");
	}
	
	public static void main(String[] args) {
		deleteUser("hi");
	}
}
