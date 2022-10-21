package com.example.searchdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ModelAdapter(modelArrayList: ArrayList<Model>) : RecyclerView.Adapter<ModelAdapter.ViewHolder>() {
    // creating a variable for array list and context.
    private var modelArrayList: ArrayList<Model>

    // method for filtering our recyclerview items.
    fun filterList(filterList: ArrayList<Model>) {
        // below line is to add our filtered
        // list in our model array list.
        modelArrayList = filterList
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // below line is to inflate our layout.
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.model_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // setting data to our views of recycler view.
        val model: Model = modelArrayList[position]
        holder.modelNameTV.setText(model.getModelName())
        holder.modelColorTV.setText(model.getModelColor())
    }

    override fun getItemCount(): Int {
        // returning the size of array list.
        return modelArrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // creating variables for our views.
        lateinit var modelNameTV: TextView
        lateinit var modelColorTV: TextView

        init {
            // initializing our views with their ids.
            modelNameTV = itemView.findViewById(R.id.idTVModelName)
            modelColorTV = itemView.findViewById(R.id.idTVModelColor)
        }
    }

    // creating a constructor for our variables.
    init {
        this.modelArrayList = modelArrayList
    }
}