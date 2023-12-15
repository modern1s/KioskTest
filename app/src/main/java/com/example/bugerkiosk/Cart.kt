package com.example.bugerkiosk

class Cart {
    private val items = mutableListOf<String>()

    fun addItem(item: String) {
        items.add(item)
    }

    fun displayCart() {
        println("장바구니:")
        items.forEachIndexed { index, item ->
            println("${index + 1}: $item")
        }
    }

    fun checkout() {
        println("결제가 완료되었습니다. 다음과 같은 항목이 있습니다:")
        displayCart()
        items.clear()
    }
}
