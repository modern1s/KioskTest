package com.example.bugerkiosk

class Menu {
    private val categories = mutableMapOf<String, Category>()

    fun addCategory(name: String, category: Category) {
        categories[name] = category
    }

    fun getCategory(name: String): Category? {
        return categories[name]
    }

    fun getCategories(): Set<String> {
        return categories.keys
    }
}