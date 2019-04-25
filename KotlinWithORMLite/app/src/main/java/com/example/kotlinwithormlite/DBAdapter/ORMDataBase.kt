package com.example.kotlinwithormlite.DBAdapter

import android.database.sqlite.SQLiteDatabase
import com.example.kotlinwithormlite.App
import com.example.kotlinwithormlite.DBAdapter.Tables.TestTable
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

object ORMDataBase: OrmLiteSqliteOpenHelper(App.instance, "Test.db", null, 1) {
    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTableIfNotExists(connectionSource,TestTable::class.java)
    }

    override fun onUpgrade(database: SQLiteDatabase?, connectionSource: ConnectionSource?, oldVersion: Int, newVersion: Int) {
        TableUtils.dropTable<TestTable,Any>(connectionSource,TestTable::class.java,true)
        onCreate(database,connectionSource)
    }
}