package com.project.marketkurly.mobileclientcommon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.project.marketkurly.mobileclientcommon.R
import com.project.marketkurly.mobileclientcommon.network.GithubClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val arrayOfListView = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input_edit = findViewById<EditText>(R.id.search_input)
        val search_btn = findViewById<Button>(R.id.search_btn)
        val listview = findViewById<ListView>(R.id.github_list)
        search_btn.setOnClickListener {
            arrayOfListView.clear()
            GithubClient.getApi().getRepos(input_edit.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ items ->
                    items.forEach {
                        println(it)
                        arrayOfListView.add(it.toString())}
                }, { e ->
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
                })
            var listview_adapter = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1, arrayOfListView)
            listview.adapter = listview_adapter
        }
    }
}