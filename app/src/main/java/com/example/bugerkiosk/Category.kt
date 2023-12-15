package com.example.bugerkiosk

class Category(val name: String) {
    private val menus = mutableListOf<String>()

    fun addMenu(menu: String) {
        menus.add(menu)
    }

    fun getMenus(): List<String> {
        return menus
    }
}
