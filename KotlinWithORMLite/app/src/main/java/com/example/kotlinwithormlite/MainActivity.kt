package com.example.kotlinwithormlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlinwithormlite.DBAdapter.Tables.TestTable
import com.example.kotlinwithormlite.DBAdapter.Tables.TestingTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val dao = TestTable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_create.setOnClickListener(this)
        btn_query.setOnClickListener(this)
        btn_remove.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btn_create -> {
                for (id in 1..10){
                    dao.add(TestingTable(null, id.toString(), ('a' + id - 1).toString()))
                }
                Toast.makeText(this,"Create Table Success", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
