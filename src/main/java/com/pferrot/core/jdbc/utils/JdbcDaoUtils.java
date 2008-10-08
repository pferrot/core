package com.pferrot.core.jdbc.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.pferrot.core.jdbc.JdbcConsts;

/**
 * Some useful JDBC utils methods. 
 * 
 * @author Patrice
 *
 */
public class JdbcDaoUtils extends JdbcDaoSupport {
	
	// Map containing the current highest ID for a given table.
	// If not in the map, then a query will be executed against the DB to find it and
	// then stored in this map.
	private final static Map<String, Integer> TABLE_VS_ID = new HashMap<String, Integer>();
	
	private final static String TABLENAME_COLUMNNAME_KEY_SEPARATOR = ":";
	
	/**
	 * Returns the next unique ID for a table, given the table name and column name.
	 * TODO: is it necessary to make this method synchronized ?
	 * 
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	public synchronized Integer getNextId(final String tableName, final String columnName) {
		final String key = tableName + TABLENAME_COLUMNNAME_KEY_SEPARATOR + columnName;
		
		Integer currentHighest = TABLE_VS_ID.get(key);
		int result;
		// Needs to query the DB.
		if (currentHighest == null) {
			result = getHighestIdFromDB(tableName, columnName);
			result++;
		}
		else {
			result = currentHighest.intValue() + 1;
		}
		Integer resultInteger = new Integer(result);
		TABLE_VS_ID.put(key, resultInteger);
		
		return resultInteger;		
	}
	
	/**
	 * Returns the next unique ID for a table, using the default column name.
	 * 
	 * @param tableName
	 * @return
	 */
	public Integer getNextId(final String tableName) {
		return getNextId(tableName, JdbcConsts.DEFAULT_ID_COLUMN_NAME);
	}
	
	/**
	 * Returns the highest ID, 0 if there is no row.
	 * 
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	private int getHighestIdFromDB(final String tableName, final String columnName) {
		return getJdbcTemplate().queryForInt("select max(" + columnName + ") from " + tableName);
	}

}
