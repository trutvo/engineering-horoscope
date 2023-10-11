package com.github.engineeringhoroscope.views.main

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.component.Key
import com.vaadin.flow.component.notification.Notification

@PageTitle("Main")
@Route(value = "")
class MainView(
        name: TextField = TextField("Your name"),
        sayHello: Button = Button("Say hello")
): HorizontalLayout() {
    init {
        sayHello.addClickListener {
            Notification.show("Hello, ${name.value}")
        }
        sayHello.addClickShortcut(Key.ENTER)

        isMargin = true
        setVerticalComponentAlignment(FlexComponent.Alignment.END, name, sayHello)

        add(name, sayHello);
    }
}