package com.example.layout

import com.example.layout.DefaultView.Companion.VIEW_NAME
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.ui.VerticalLayout
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Label


@SpringView(name = "")
class DefaultView : VerticalLayout(), View {

    init {
        addComponent(Label("This is the default view"))
    }

    override fun enter(event: ViewChangeEvent) {
        // This view is constructed in the init() method()
    }

    companion object {
        val VIEW_NAME = ""
    }
}