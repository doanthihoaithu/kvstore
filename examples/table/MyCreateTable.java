/*-
 * Copyright (C) 2011, 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * This file was distributed by Oracle as part of a version of Oracle NoSQL
 * Database made available at:
 *
 * http://www.oracle.com/technetwork/database/database-technologies/nosqldb/downloads/index.html
 *
 * Please see the LICENSE file included in the top-level directory of the
 * appropriate version of Oracle NoSQL Database for a copy of the license and
 * additional information.
 */

package table;

import models.Country;
import models.Student;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.table.Row;
import oracle.kv.table.Table;

/**
 * Example 4: Parent and Child tables
 *
 * This example demonstrates use of parent and child tables.  The parent
 * table is the shardUsers table used above and the child table is a
 * table of addresses for a given user, allowing definition of multiple
 * addresses for a user.
 */
public class MyCreateTable extends BaseExample {

    @Override
    public String getShortDescription() {
        return "Create Student, Country tables!";
    }

    @Override
    public void setup() {

        executeDDL(
                "CREATE TABLE IF NOT EXISTS countries  " +
                        "(country_name STRING, " +
                        " country_code STRING, " +
                        " country_id INTEGER, " +
                        " PRIMARY KEY (country_id))");

        executeDDL("CREATE TABLE IF NOT EXISTS countries.students  " +
                "(first_name STRING, " +
                " last_name STRING, " +
                " student_id INTEGER, " +
                " age INTEGER, " +
                " PRIMARY KEY (student_id))");


        executeDDL(
                "CREATE INDEX IF NOT EXISTS firstlast ON " +
                        "countries.students(first_name, last_name)");
    }

    @Override
    public void teardown() {
        executeDDL("DROP INDEX IF EXISTS firstlast ON countries.students");
        executeDDL ("DROP TABLE IF EXISTS countries");
        executeDDL ("DROP TABLE IF EXISTS countries.students");
    }

    @Override
    public Void call() {
        Table parentTable = getTable("countries");
        Table childTable = parentTable.getChildTable("students");
//        Table countryTable = parentTable.getChildTable("coutries");
//        Table childTable = getTable("simpleUsers");


        /*
         * Insert rows into the child table.  Create a parent table
         * record first.
         */
        /* Create a parent (user) row. */
        Row row = parentTable.createRow();
        Country country = new Country();
        for (int i =1; i <= Country.codes.length-1;i++) {

            country.setInformationById(i);
            row.put("country_name", country.getcountryName());
            row.put("country_code", country.getcountryCode());
            row.put("country_id",i);
            getTableAPI().put(row, null, null);
        }


        /*
         * Create multiple child rows for the same parent.  To do this
         * create a row using the child table but be sure to set the
         * inherited parent table primary key fields (firstName and
         * lastName).
         */
        long begin = System.currentTimeMillis();
        int numberRowImport = 100000;
        Student student = new Student();
        for (int i = 1; i <= numberRowImport; i++) {
            row = childTable.createRow();

            /* Parent key fields */
            row.put("country_id", Country.getRanDom());
            /* Child key */
            student.setStudentId(i);
            row.put("student_id", student.getStudentId());
            /* Child data fields */
            student.setRandomInfor();
            row.put("age", student.getAge());
            row.put("first_name", student.getFirstName());
            row.put("last_name", student.getLastName());
            getTableAPI().putIfAbsent(row, null, null);
        }
        long end = System.currentTimeMillis();
        System.out.println("import " + numberRowImport + " rows takes " + (end - begin) + " millis time" );


        /*
         * Reuse the Row to avoid repeating all fields.  This is safe.
         * This requires a new child key and data.
         */
//        row.put("addressID", 2);
//        row.put("Street", "Someplace Ave. 162");
//        row.put("State", "California");
//        row.put("ZIP", 90014);
//        row.put("addressName", "work");
//        getTableAPI().putIfAbsent(row, null, null);

        /*
         * Retrieve rows from the child table.
         * The child table primary key is a concatenation of its parent table's
         * primary key and it's own defined fields.
         */
//        Row row = childTable.createRow();
//        PrimaryKey key = childTable.createPrimaryKey();
//        key.put("student_id", 1);
//        key.put("country_id", 1);
//        row = getTableAPI().get(key, null);
//
//        System.out.println(row.toJsonString(true));

        /*
         * There is an index on the "addressName" field of the child table.
         * Use that to retrieve all "work" addresses.
         */
//        Index index = childTable.getIndex("addressIndex");
//        IndexKey indexKey = index.createIndexKey();
//        indexKey.put("addressName", "work");

//        TableIterator<Row> iter = null;
//        try {
////            iter =  getTableAPI().tableIterator(indexKey, null, null);
//            iter = getTableAPI().tableIterator(key,null, null);
////            System.out.println("\nAll \"work\" addresses");
//
//            while(iter.hasNext()) {
//                row = iter.next();
//                System.out.println(row.toJsonString(true));
//            }
//        } finally {
//            if (iter != null) {
//                iter.close();
//            }
//        }
        return null;
    }

    public void call(String [] args) {
        if (args.length == 0) {
            Table parentTable = getTable("countries");
            Table childTable = parentTable.getChildTable("students");
            Row row = parentTable.createRow();
            Country country = new Country();
            for (int i =1; i <= Country.codes.length-1;i++) {

                country.setInformationById(i);
                row.put("country_name", country.getcountryName());
                row.put("country_code", country.getcountryCode());
                row.put("country_id",i);
                getTableAPI().put(row, null, null);
            }
            long begin = System.currentTimeMillis();
            int numberRowImport = 1000000;
            Student student = new Student();
            for (int i = 1; i <= numberRowImport; i++) {
                row = childTable.createRow();

                /* Parent key fields */
                row.put("country_id", Country.getRanDom());
                /* Child key */
                student.setStudentId(i);
                row.put("student_id", student.getStudentId());
                /* Child data fields */
                student.setRandomInfor();
                row.put("age", student.getAge());
                row.put("first_name", student.getFirstName());
                row.put("last_name", student.getLastName());
                getTableAPI().putIfAbsent(row, null, null);
            }
            long end = System.currentTimeMillis();
            System.out.println("import " + numberRowImport + " rows takes " + (end - begin) + " millis time" );
        }
        else {
            int startId = Integer.parseInt(args[0]);
            int endId = Integer.parseInt(args[1]);
            System.out.println(startId);
            System.out.println(endId);
            Table parentTable = getTable("countries");
            Table childTable = parentTable.getChildTable("students");
            Row row = parentTable.createRow();
//            Country country = new Country();
//            for (int i =1; i <= Country.codes.length-1;i++) {
//
//                country.setInformationById(i);
//                row.put("country_name", country.getcountryName());
//                row.put("country_code", country.getcountryCode());
//                row.put("country_id",i);
//                getTableAPI().put(row, null, null);
//            }
            long begin = System.currentTimeMillis();
            Student student = new Student();
            for (int i = startId; i <= endId; i++) {
                row = childTable.createRow();

                /* Parent key fields */
                row.put("country_id", Country.getRanDom());
                /* Child key */
                student.setStudentId(i);
                row.put("student_id", student.getStudentId());
                /* Child data fields */
                student.setRandomInfor();
                row.put("age", student.getAge());
                row.put("first_name", student.getFirstName());
                row.put("last_name", student.getLastName());
                getTableAPI().putIfAbsent(row, null, null);
            }
            long end = System.currentTimeMillis();
            System.out.println("import " + (endId - startId + 1) + " rows takes " + (end - begin) + " millis time" );
        }

    }

    public static void main(String[] args) {
        String storeName = "kvstore";
        String hostName = "localhost";
        String hostPort = "5000";
        KVStore kvStore = KVStoreFactory.getStore(new KVStoreConfig(storeName, hostName
                + ":" + hostPort));
        MyCreateTable instance = new MyCreateTable();
        instance.init(kvStore);
//        instance.teardown();
//        instance.setup();
        instance.call(args);
    }

}
