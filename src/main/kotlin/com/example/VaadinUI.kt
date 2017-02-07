package com.example

import com.vaadin.annotations.Theme
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import org.springframework.beans.factory.annotation.Autowired


@Theme("valo")
@SpringUI(path = "")
class VaadinUI : UI() {

    @Autowired
    internal var myService: MyService? = null

    override fun init(request: VaadinRequest) {
        content = Label(myService!!.sayHi())
    }

}
