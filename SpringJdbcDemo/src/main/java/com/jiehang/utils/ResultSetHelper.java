package com.jiehang.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultSetHelper
{

    public ResultSetHelper()
    {
    }

    public static Boolean getBoolean(ResultSet resultSet, int index)
        throws SQLException
    {
        Boolean value = Boolean.valueOf(resultSet.getBoolean(index));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Boolean getBoolean(ResultSet resultSet, String name)
        throws SQLException
    {
        Boolean value = Boolean.valueOf(resultSet.getBoolean(name));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Byte getByte(ResultSet resultSet, int index)
        throws SQLException
    {
        Byte value = Byte.valueOf(resultSet.getByte(index));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Byte getByte(ResultSet resultSet, String name)
        throws SQLException
    {
        Byte value = Byte.valueOf(resultSet.getByte(name));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Integer getInt(ResultSet resultSet, int index)
        throws SQLException
    {
        Integer value = Integer.valueOf(resultSet.getInt(index));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Integer getInt(ResultSet resultSet, String name)
        throws SQLException
    {
        Integer value = Integer.valueOf(resultSet.getInt(name));
        if(resultSet.wasNull())
            value = null;
        return value;
    }
    
    public static Integer getInteger(ResultSet resultSet, int index)
            throws SQLException
    {
        Integer value = Integer.valueOf(resultSet.getInt(index));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Integer getInteger(ResultSet resultSet, String name)
        throws SQLException
    {
        Integer value = Integer.valueOf(resultSet.getInt(name));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Long getLong(ResultSet resultSet, int index)
        throws SQLException
    {
        Long value = Long.valueOf(resultSet.getLong(index));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Long getLong(ResultSet resultSet, String name)
        throws SQLException
    {
        Long value = Long.valueOf(resultSet.getLong(name));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static BigDecimal getBigDecimal(ResultSet resultSet, int index)
        throws SQLException
    {
        BigDecimal value = resultSet.getBigDecimal(index);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static BigDecimal getBigDecimal(ResultSet resultSet, String name)
        throws SQLException
    {
        BigDecimal value = resultSet.getBigDecimal(name);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Number getNumber(ResultSet resultSet, int index)
        throws SQLException
    {
        Number value = (Number)resultSet.getObject(index);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Number getNumber(ResultSet resultSet, String name)
        throws SQLException
    {
        Number value = (Number)resultSet.getObject(name);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Double getDouble(ResultSet resultSet, int index)
        throws SQLException
    {
        Double value = Double.valueOf(resultSet.getDouble(index));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Double getDouble(ResultSet resultSet, String name)
        throws SQLException
    {
        Double value = Double.valueOf(resultSet.getDouble(name));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Float getFloat(ResultSet resultSet, int index)
        throws SQLException
    {
        Float value = Float.valueOf(resultSet.getFloat(index));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Float getFloat(ResultSet resultSet, String name)
        throws SQLException
    {
        Float value = Float.valueOf(resultSet.getFloat(name));
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static String getString(ResultSet resultSet, int index)
        throws SQLException
    {
        String value = resultSet.getString(index);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static String getString(ResultSet resultSet, String name)
        throws SQLException
    {
        String value = resultSet.getString(name);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Date getDate(ResultSet resultSet, int index)
        throws SQLException
    {
        Date value = resultSet.getDate(index);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Date getDate(ResultSet resultSet, String name)
        throws SQLException
    {
        Date value = resultSet.getDate(name);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Timestamp getTimestamp(ResultSet resultSet, int index)
        throws SQLException
    {
        Timestamp value = resultSet.getTimestamp(index);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Timestamp getTimestamp(ResultSet resultSet, String name)
        throws SQLException
    {
        Timestamp value = resultSet.getTimestamp(name);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static byte[] getBlob(ResultSet resultSet, int index)
        throws SQLException
    {
        Blob value = resultSet.getBlob(index);
        if(resultSet.wasNull())
            value = null;
        return value != null ? value.getBytes(0L, (int)value.length()) : null;
    }

    public static byte[] getBlob(ResultSet resultSet, String name)
        throws SQLException
    {
        Blob value = resultSet.getBlob(name);
        if(resultSet.wasNull())
            value = null;
        return value != null ? value.getBytes(0L, (int)value.length()) : null;
    }

    public static String getClob(ResultSet resultSet, int index)
        throws SQLException
    {
        Clob value = resultSet.getClob(index);
        if(resultSet.wasNull())
            value = null;
        return value != null ? value.getSubString(0L, (int)value.length()) : null;
    }

    public static String getClob(ResultSet resultSet, String name)
        throws SQLException
    {
        Clob value = resultSet.getClob(name);
        if(resultSet.wasNull())
            value = null;
        return value != null ? value.getSubString(0L, (int)value.length()) : null;
    }

    public static Object getObject(ResultSet resultSet, int index)
        throws SQLException
    {
        Object value = resultSet.getObject(index);
        if(resultSet.wasNull())
            value = null;
        return value;
    }

    public static Object getObject(ResultSet resultSet, String name)
        throws SQLException
    {
        Object value = resultSet.getObject(name);
        if(resultSet.wasNull())
            value = null;
        return value;
    }
    
    
    
    public Object FileMatchColumn(ResultSet resultSet, Object obj) {
		Set<Field> fields = new HashSet<Field>();
		fields.addAll(Arrays.asList(obj.getClass().getDeclaredFields()));
		Class<?> superClazz = obj.getClass().getSuperclass();
		while(superClazz != null && !superClazz.getName().equalsIgnoreCase("java.lang.object")) {
			Field[] superFields = superClazz.getDeclaredFields();
			for(Field superfield : superFields) {
				if(superfield.getModifiers() != 2) {
					fields.add(superfield);
				}
			}
			superClazz = superClazz.getClass().getSuperclass();
		}
		Iterator<Field> fieldIter = fields.iterator();
		String fielName = null;
		String columnName = null;
		String fielTypeName = null;
		StringBuilder methodName = null;
		Method method = null;
		while(fieldIter.hasNext()) {
			Field f = fieldIter.next();
			fielName = f.getName();;
			Pattern pattern = Pattern.compile("(\\B[A-Z])");
			Matcher matcher = pattern.matcher(fielName);
			while(matcher.find()) {
				columnName = fielName.replaceAll(matcher.group(), "_"+matcher.group());
			}
			columnName = columnName.toUpperCase();
			
			fielTypeName = f.getType().toString();
			fielTypeName = fielTypeName.substring(fielTypeName.lastIndexOf(".")+1, fielTypeName.length());
			methodName = (new StringBuilder()).append("get").append(Character.toUpperCase(fielTypeName.charAt(0))).append(fielTypeName.substring(1));
			try {
				method = this.getClass().getMethod(methodName.toString(), new Class[] { ResultSet.class, String.class });
				f.setAccessible(true);
				f.set(obj, method.invoke(null, resultSet, columnName));
			} catch (SecurityException e) {
				e.printStackTrace();
				System.out.println("Error: " + fielName + "--" + columnName);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				System.out.println("Error: " + fielName + "--" + columnName);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				System.out.println("Error: " + fielName + "--" + columnName);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				System.out.println("Error: " + fielName + "--" + columnName);
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				System.out.println("Error: " + fielName + "--" + columnName);
			}
		}
		return obj;
	}
    
}