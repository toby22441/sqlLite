package com.example.toby.sqllite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.content.Context
import android.database.Cursor
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {



    lateinit var editTextID: EditText
    lateinit var editTextTitle: EditText
    lateinit var editTextArtist: EditText
    lateinit var editTextYear: EditText

    lateinit var buttonAdd: Button
    lateinit var buttonSearch: Button
    lateinit var buttonUpdate: Button
    lateinit var buttonDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextID = findViewById(R.id.etID)
        editTextTitle = findViewById(R.id.etTitle)
        editTextArtist = findViewById(R.id.etArtist)
        editTextYear = findViewById(R.id.etYear)

        buttonAdd = findViewById(R.id.btnAdd)
        buttonSearch = findViewById(R.id.btnSearch)
        buttonUpdate = findViewById(R.id.btnUpdate)
        buttonDelete = findViewById(R.id.btnDelete)

        buttonAdd.setOnClickListener{
        var id = editTextID
        var t = editTextTitle
        var a = editTextArtist
        var y = editTextYear

            var ins = MyHelper()
            ins.insertRecord = (id, a, t, y)


        }
    }

    }


class MyHelper(ctx:Context) : SQLiteOpenHelper(ctx,"TestDB", null, 1) {


    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL ("CREATE TABLE IF NOT EXISTS Songs(ID INTEGER PRIMARY KEY, Title VARCHAR(255), Artist VARCHAR(255), Year INTEGER)")
    }

    override fun onUpgrade(db:SQLiteDatabase, oldVersion:Int, newVersion:Int) {
        db.execSQL ("DROP TABLE IF EXISTS Songs")
        onCreate(db)
    }

    fun insertRecord() : Long{
        val db = getWritableDatabase()
        val stmt = db.compileStatement ("INSERT INTO Songs(ID,Title,Artist,Year) VALUES (?, ?, ?,?)");
        stmt.bindString (1, ())
        stmt.bindString (2, "Smith")
        stmt.bindLong (3, 53)
        val id = stmt.executeInsert()
        return id
    }


}
