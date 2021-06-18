package com.edu.icesi.ci.taller4.back.service.interfaces;

//import java.util.Optional;

public interface UserselectService {
	public boolean saveUserSelect(long id, String tableName, String keyColumn, String userValue, String statement, long triggerId);
	public boolean editUserSelect(long id, String newTablename, String newKeycolumn, String newUserValue, String newStatment);
	/*public Iterable<Userselect> findAll();
	public Userselect save(Userselect userselect);
	public Optional<Userselect> findById(long id);
	public void delete(Userselect ussel);*/
}
