package se.jensim.routes

import se.jensim.layout.MainMenu
import com.vaadin.annotations.Theme
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewDisplay
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.spring.annotation.SpringViewDisplay
import com.vaadin.ui.*
import org.springframework.beans.factory.annotation.Autowired


@Theme("valo")
@SpringUI(path = "/")
@SpringViewDisplay
class MyVaadinUI : UI(), ViewDisplay {

    @Autowired
    private lateinit var menu: MainMenu
    private val springViewDisplay = Panel()

    override fun init(request: VaadinRequest) {
        val root = VerticalLayout()
        root.setSizeFull()
        content = root

        root.addComponent(menu)

        springViewDisplay.setSizeFull()
        root.addComponent(springViewDisplay)
        root.setExpandRatio(springViewDisplay, 1.0f)
    }

    override fun showView(view: View) {
        springViewDisplay.content = view as Component
    }
}
