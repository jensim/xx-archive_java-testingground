package com.example.layout

import com.example.routes.MyVaadinUI
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout

@SpringView(name = "order", ui = arrayOf(MyVaadinUI::class))
class OrderLayout : VerticalLayout(), View {

    val NAVSTR: String = "ORDER"

    private val nameField = TextField()
    private val addressField = TextField()
    private val cityField = TextField()
    private val phoneField = TextField()

    init {
//        addressField.addValidator { e -> e. }

        addComponent(HorizontalLayout(Label("Name"), nameField))
        addComponent(HorizontalLayout(Label("Address"), addressField))
        addComponent(HorizontalLayout(Label("City"), cityField))
        addComponent(HorizontalLayout(Label("Phone"), phoneField))

        setSizeFull()
    }

    override fun enter(event: ViewChangeListener.ViewChangeEvent?) {
    }

    fun reset() {
        nameField.value = ""
    }
}