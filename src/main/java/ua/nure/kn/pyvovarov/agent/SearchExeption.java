package ua.nure.kn.pyvovarov.agent;

import ua.nure.kn.pyvovarov.db.DataBaseException;

public class SearchExeption {

	public SearchException(DataBaseException e) {
		e.printStackTrace();
	}
}
