/**
 * 
 */
package com.whu.pro.mapper.result;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * @author Michael
 *
 */
public class PointResult extends BaseTypeHandler<byte[]> {
    byte[] Data;

    public void setData(byte[] Data) {
        this.Data = Data;
    }

    public byte[] getData() {
        return Data;
    }

    //private static final Log LOGGER = LogFactory.getLog(PointResult.class);
    // Ö¸¶¨×Ö·û¼¯  
    @SuppressWarnings("unused")
    private static final String DEFAULT_CHARSET = "utf-8";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, byte[] parameter, JdbcType jdbcType)
            throws SQLException {
        ByteArrayInputStream bis;
        //bis = new ByteArrayInputStream(parameter.getBytes(1, (int) parameter.length()));
        //ps.setBinaryStream(i, bis, parameter.length() - 1);
        bis = new ByteArrayInputStream(parameter);
        ps.setBinaryStream(i, bis, parameter.length);
    }

    @Override
    public byte[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Blob blob = rs.getBlob(columnName);
        return blob.getBytes(1, (int) blob.length());
        //return rs.getBlob(columnName);
        /*int size = rs.getFetchSize();
        int length = 0;
        for (int i = 0; i < size; i++) {
            Blob blob = rs.getBlob(columnName);
            length += blob.getBytes(1, (int) blob.length()).length;
            rs.next();
        }
        rs.first();
        byte[] values = new byte[length];
        int current = 0;
        for (int i = 0; i < size; i++) {
            Blob blob = rs.getBlob(columnName);
            if (null != blob) {
                System.arraycopy(blob.getBytes(1, (int) blob.length()), 1, values, current,
                        blob.getBytes(1, (int) blob.length()).length);
                current += blob.getBytes(1, (int) blob.length()).length;
            }
            rs.next();
        }
        System.out.println("Fetch size: " + size + " length: " + values.length);
        return values;*/
    }

    @Override
    public byte[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Blob blob = cs.getBlob(columnIndex);
        return blob.getBytes(1, (int) blob.length());
        //return cs.getBlob(columnIndex);
        /*ResultSet rs = cs.getResultSet();
        int size = rs.getFetchSize();
        int length = 0;
        for (int i = 0; i < size; i++) {
            Blob blob = rs.getBlob(columnIndex);
            length += blob.getBytes(1, (int) blob.length()).length;
        }
        rs.first();
        byte[] values = new byte[length];
        int current = 0;
        for (int i = 0; i < size; i++) {
            Blob blob = rs.getBlob(columnIndex);
            if (null != blob) {
                System.arraycopy(blob.getBytes(1, (int) blob.length()), 1, values, current,
                        blob.getBytes(1, (int) blob.length()).length);
                current += blob.getBytes(1, (int) blob.length()).length;
            }
            rs.next();
        }
        System.out.println("Fetch size: " + size + " length: " + values.length);
        return values;*/
    }

    /**
     * @Description:
     * 
     * @param arg0
     * @param arg1
     * @return
     * @throws SQLException
     * 
     * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet,
     *      int)
     * 
     */

    @Override
    public byte[] getNullableResult(ResultSet rs, int columnName) throws SQLException {
        Blob blob = rs.getBlob(columnName);
        return blob.getBytes(1, (int) blob.length());
        //return rs.getBlob(columnName);
        /*int size = rs.getFetchSize();
        int length = 0;
        for (int i = 0; i < size; i++) {
            Blob blob = rs.getBlob(columnName);
            length += blob.getBytes(1, (int) blob.length()).length;
            rs.next();
        }
        rs.first();
        byte[] values = new byte[length];
        int current = 0;
        for (int i = 0; i < size; i++) {
            Blob blob = rs.getBlob(columnName);
            if (null != blob) {
                System.arraycopy(blob.getBytes(1, (int) blob.length()), 1, values, current,
                        blob.getBytes(1, (int) blob.length()).length);
                current += blob.getBytes(1, (int) blob.length()).length;
            }
            rs.next();
        }
        System.out.println("Fetch size: " + size + " length: " + values.length);
        return values;*/
    }
}
