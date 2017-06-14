/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workshop.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pradip
 */
public class TableManager {
   public static DefaultTableModel buildDataTable(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        Object[] columnNames = new Object[columnCount];
        int index = 0;
        for (int column = 1; column <= columnCount; column++) {
            columnNames[index] = metaData.getColumnName(column).toUpperCase();
            index++;
        }
        rs.last();
        Object[][] data = new Object[rs.getRow()][columnCount];
        rs.beforeFirst();
        while (rs.next()) {
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                data[rs.getRow() - 1][columnIndex - 1] = rs.getObject(columnIndex);
            }
        }
        return new DefaultTableModel(data, columnNames); 
}
}