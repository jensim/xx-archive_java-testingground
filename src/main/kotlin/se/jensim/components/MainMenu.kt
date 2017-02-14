package se.jensim.components;

import com.vaadin.spring.annotation.SpringComponent
import com.vaadin.spring.annotation.UIScope
import com.vaadin.ui.MenuBar
import se.jensim.view.DefaultView
import se.jensim.view.OrderView

@SpringComponent
@UIScope
class MainMenu : MenuBar() {

    init {
        addItem("Home") { ui.navigator.navigateTo(DefaultView.VIEW_NAME) }
        addItem("Order") { ui.navigator.navigateTo(OrderView.VIEW_NAME) }
    }
}
