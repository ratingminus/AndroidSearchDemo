package com.example.searchdemo

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class SearchActivity : AppCompatActivity() {
    // creating variables for
    // our ui components.
    private lateinit var modelRV : RecyclerView

    // variable for our adapter
    // class and array list
    private lateinit var adapter: ModelAdapter
    private lateinit var modelArrayList: ArrayList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        //init variable
        modelRV = findViewById(R.id.idRVModels)

        //calling method to build RV
        buildRecyclerView()
    }

    // calling on create option menu
    // layout to inflate our menu file.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // below line is to get our inflater
        val inflater = menuInflater

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu)

        // below line is to get our menu item.
        val searchItem = menu.findItem(R.id.actionSearch)

        // getting search view of our item.
        val searchView = MenuItemCompat.getActionView(searchItem) as SearchView
        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist = ArrayList<Model>()

        // running a for loop to compare elements.
        for (item in modelArrayList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getModelName().toLowerCase(Locale.ROOT).contains(text.lowercase(Locale.getDefault()))) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist)
        }
    }

    private fun buildRecyclerView() {

        // below line we are creating a new array list
        modelArrayList = ArrayList<Model>()

        // below line is to add data to our array list.
        modelArrayList.add(Model("Sharara", "White"))
        modelArrayList.add(Model("Shamik", "Black"))
        modelArrayList.add(Model("Avishek", "Colorless"))
        modelArrayList.add(Model("Fahim sir", "Rainbow"))

        // initializing our adapter class.
        adapter = ModelAdapter(modelArrayList)

        // adding layout manager to our recycler view.
        val manager = LinearLayoutManager(this)
        modelRV.setHasFixedSize(true)

        // setting layout manager
        // to our recycler view.
        modelRV.layoutManager = manager

        // setting adapter to
        // our recycler view.
        modelRV.adapter = adapter
    }
}