package com.edu.icesi.ci.taller4.back.service.implementation;

//import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.UserselectDao;
import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.model.Userselect;
import com.edu.icesi.ci.taller4.back.repository.TriggerrRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.UserselectService;

@Service
public class UserselectServiceImp implements UserselectService{
	
	private UserselectDao usseldao;
	private TriggerrRepository triggerepo;
	
	@Autowired
	public UserselectServiceImp(UserselectDao usseldao,TriggerrRepository triggerepo) {
		this.usseldao = usseldao;
		this.triggerepo = triggerepo;
	}
	
	@Override
	public boolean saveUserSelect(long id, String tableName, String keyColumn, String userValue, String statement, long triggerId) {
		try {
			Triggerr trigger = triggerepo.findById(triggerId).get();
			
			Userselect userselect = new Userselect();
			userselect.setUsselId(id);
			
			if(tableName.contains(" ") || keyColumn.contains(" ")) {
				throw new RuntimeException();
			}
			
			if(userValue.equals("") || statement.equals("")) {
				throw new RuntimeException();
			}
			
			userselect.setUsselTablename(tableName);
			userselect.setUsselValuekeycolumn(keyColumn);
			userselect.setUsselValueusercolumn(userValue);
			userselect.setUsselWherestatement(statement);
			userselect.setTriggerr(trigger);
			
			usseldao.Save(userselect);			
			return true;
		}
		catch(RuntimeException rte) {
			return false;
		}		
	}

	@Override
	@Transactional
	public boolean editUserSelect(long id, String newTablename, String newKeycolumn, String newUserValue,
			String newStatment) {		
		try {
			Userselect userselect = usseldao.findById(id);
			if(userselect != null) {
				Userselect usersel = userselect;
				if(newTablename.contains(" ") || newKeycolumn.contains(" ")) {
					throw new RuntimeException();
				}
				
				if(newUserValue.equals("") || newStatment.equals("")) {
					throw new RuntimeException();
				}				
				usersel.setUsselTablename(newTablename);
				usersel.setUsselValuekeycolumn(newKeycolumn);
				usersel.setUsselValueusercolumn(newUserValue);
				usersel.setUsselWherestatement(newStatment);
				usseldao.Save(usersel);
				return true;
			}
			else {
				return false;
			}
		}
		catch(RuntimeException rte) {
			return false;
		}		
	}

	/*@Override
	public Iterable<Userselect> findAll() {
		return userselectrepo.findAll();
	}

	@Override
	public Userselect save(Userselect userselect) {
		return userselectrepo.save(userselect);
	}

	@Override
	public Optional<Userselect> findById(long id) {
		return userselectrepo.findById(id);
	}

	@Override
	public void delete(Userselect ussel) {
		userselectrepo.delete(ussel);		
	}*/
}