package se.jensim.layout;

import com.vaadin.spring.annotation.SpringComponent
import com.vaadin.spring.annotation.UIScope
import com.vaadin.ui.MenuBar

@SpringComponent
@UIScope
class MainMenu : MenuBar() {

    init {
        addItem("Home") { ui.navigator.navigateTo(DefaultView.VIEW_NAME) }
        addItem("Order") { ui.navigator.navigateTo(OrderView.VIEW_NAME) }
    }
}
