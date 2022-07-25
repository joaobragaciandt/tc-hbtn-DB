package org.example;


import java.util.HashMap;
import java.util.Map;

public class PrintJDBCDrivers {

    static Map<String,String> driverNames;

    public static void insereDrivers() {
        driverNames = new HashMap<>();

        driverNames.put("PostgreSQL","org.postgresql.Driver");
        driverNames.put("Firebird SQL","org.firebirdsql.jdbc.FBDriver");
        driverNames.put("H2 Database Engine","org.h2.Driver");
        driverNames.put("IBM DB2","com.ibm.db2.jcc.DB2Driver");
        driverNames.put("Oracle","oracle.jdbc.OracleDriver");
        driverNames.put("MariaDB","org.mariadb.jdbc.Driver");
        driverNames.put("MySQL","com.mysql.jdbc.Driver");


    }

    public static void imprimeDriverName(String key, String value) {
        System.out.println("Nome do Drive: " + key + ", Versão do drive: " + value);
    }

    public static void main(String[] args) {
        insereDrivers();
        driverNames.forEach(PrintJDBCDrivers::imprimeDriverName);
    }
}
