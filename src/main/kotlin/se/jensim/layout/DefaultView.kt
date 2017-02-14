package se.jensim.layout

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.ui.VerticalLayout
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Label


@SpringView(name = DefaultView.VIEW_NAME)
class DefaultView : VerticalLayout(), View {

    companion object {
        const val VIEW_NAME = ""
    }

    init {
        addComponent(Label("This is the default view"))
    }

    override fun enter(event: ViewChangeEvent) {
        // This view is constructed in the init() method()
    }
}