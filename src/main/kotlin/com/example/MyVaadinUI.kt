package com.example

import com.vaadin.annotations.Theme
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Label
import com.vaadin.ui.UI

@Theme("valo")
@SpringUI(path = "/hej")
class MyVaadinUI : UI() {

    override fun init(request: VaadinRequest) {
        content = Label("HEJ")
        request.attributeNames
    }
}