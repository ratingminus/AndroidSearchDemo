package com.example.searchdemo

class Model (private var modelName: String, private var modelColor: String) {
    fun getModelName() : String {
        return modelName
    }
    fun setModelName(modelName: String) {
        this.modelName = modelName
    }
    fun setModelColor(modelColor: String) {
        this.modelColor = modelColor
    }
    fun getModelColor() : String {
        return modelColor
    }
}