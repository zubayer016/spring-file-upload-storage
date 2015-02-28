package nl.runnable.spring.fileupload.impl;

/**
 * @author Laurens Fridael
 */
abstract class SqlConstants {

  static final int COLUMN_COUNT = 9;

  static final String INSERT_INTO = "INSERT INTO sfus_file " +
      "(id, name, original_filename, content_type, size, data, username, created_at, expires_at) " +
      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

  static final String SELECT_BY_ID =
      "SELECT id, name, original_filename, content_type, size, username, created_at, expires_at " +
          "FROM sfus_file WHERE id = ?";

  static final String DELETE_BY_ID = "DELETE FROM sfus_file WHERE id = ?";

  static final String SELECT_DATA_BY_ID = "SELECT data FROM sfus_file WHERE id = ?";

  static final String SELECT_COUNT = "SELECT COUNT(*) FROM sfus_file";

}
