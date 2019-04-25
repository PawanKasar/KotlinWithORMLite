package com.example.kotlinwithormlite.DBAdapter.Tables

import com.example.kotlinwithormlite.DBAdapter.ORMDataBase
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "TestTable")
data class TestingTable(

    @DatabaseField(generatedId = true)
    var id: Int? = null,

    @DatabaseField
    var category: String = "",

    @DatabaseField
    var content: String = ""

)

class TestTable{
    companion object{
        lateinit var dao: Dao<TestTable, Int>
    }

    init {
        dao = ORMDataBase.getDao(TestTable::class.java)
    }

    fun add(testTable: TestTable) = dao.createOrUpdate(testTable)

    fun update(testTable: TestTable) = dao.update(testTable)

    fun delete(testTable: TestTable) = dao.delete(testTable)

    fun queryForAll() = dao.queryForAll()

    fun removeAll(){
        for (tesTable in queryForAll()){
            dao.delete(tesTable)
        }
    }
}