package com.example.bugerkiosk


fun main() {
    val shoppingCart = Cart()
    val menu = setupMenu()

    while (true) {
        val myCategoryName = selectCategory(menu)
        val myCategory = menu.getCategory(myCategoryName)
        val myMenu = myCategory?.getMenus()?.let { selectMenu(it) } ?: continue
        val myDetail = selectDetail(myMenu)

        shoppingCart.addItem("$myMenu ($myDetail)")

        println("당신이 선택한 카테고리: $myCategory")
        println("당신이 선택한 메뉴: $myMenu")
        println("당신이 선택한 메뉴 상세: $myDetail")
        shoppingCart.displayCart()

        println("선택 옵션: [1] 결제하기, [2] 계속 쇼핑하기")
        val userChoice = readLine()?.toIntOrNull() ?: 0
        when (userChoice) {
            1 -> {
                shoppingCart.checkout()
                break
            }
            2 -> continue
            else -> println("잘못된 선택입니다. 다시 선택해주세요.")
        }
    }
}

fun setupMenu(): Menu {
    val menu = Menu()
    val burgers = Category("Burgers")
    burgers.addMenu("Cheeseburger")
    burgers.addMenu("Veggie Burger")
    burgers.addMenu("Bacon Burger")

    menu.addCategory(burgers.name, burgers)

    return menu
}
fun selectCategory(menu: Menu): String {
    println("카테고리를 선택하세요: ${menu.getCategories().joinToString(", ")}")
    val input = readLine()?.trim() ?: return selectCategory(menu)
    return if (menu.getCategories().contains(input)) input else {
        println("잘못된 선택입니다. 다시 선택해주세요.")
        selectCategory(menu)
    }
}
fun selectMenu(menus: List<String>): String {
    println("메뉴를 선택하세요: ${menus.withIndex().joinToString { "[${it.index + 1}] ${it.value}" }}")
    val input = readLine()?.toIntOrNull() ?: return selectMenu(menus)
    return menus.getOrNull(input - 1) ?: run {
        println("잘못된 선택입니다. 다시 선택해주세요.")
        selectMenu(menus)
    }
}

fun selectDetail(menu: String): String {
    println("$menu 의 매운 정도를 선택하세요: [1] 순한맛, [2] 중간맛, [3] 매운맛")
    val detailMap = mapOf(
        1 to "순한맛",
        2 to "중간맛",
        3 to "매운맛"
    )
    val input = readLine()?.toIntOrNull() ?: return selectDetail(menu)
    return detailMap[input] ?: run {
        println("잘못된 선택입니다. 다시 선택해주세요.")
        selectDetail(menu)
    }
}