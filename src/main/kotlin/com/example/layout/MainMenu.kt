package com.example.layout;

import com.vaadin.spring.annotation.SpringComponent
import com.vaadin.spring.annotation.UIScope
import com.vaadin.ui.MenuBar

@SpringComponent
@UIScope
class MainMenu : MenuBar() {

    init {
        addItem("Home") { ui.navigator.navigateTo("") }
        addItem("Order") { ui.navigator.navigateTo("order") }
    }
}
