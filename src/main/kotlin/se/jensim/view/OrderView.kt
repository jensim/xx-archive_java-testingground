package se.jensim.view

import com.vaadin.data.Binder
import com.vaadin.data.ValueProvider
import com.vaadin.data.validator.StringLengthValidator
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.server.Setter
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.*
import se.jensim.domain.Address
import se.jensim.domain.Person
import se.jensim.domain.PhoneNumber
import kotlin.reflect.KMutableProperty

@SpringView(name = OrderView.VIEW_NAME)
class OrderView : VerticalLayout(), View {

    companion object {
        const val VIEW_NAME = "order"
    }

    private val tfFirstName = TextField()
    private val tfLastName = TextField()
    private val tfAddress = TextField()
    private val tfCity = TextField()
    private val tfPhone = TextField()

    private var person = Person("")
    private val personBinder = Binder<Person>(Person::class.java)
    private val phoneBinder = Binder<PhoneNumber>(PhoneNumber::class.java)
    private val addressBinder = Binder<Address>(Address::class.java)

    init {
        personBinder.bean = person
        phoneBinder.bean = person.phoneNumber1
        addressBinder.bean = person.address

        addComponent(HorizontalLayout(Label("First name"), tfFirstName))
        personBinder.forField(tfFirstName).withValidator(StringLengthValidator("Too short", 2, 100)).bind(Person::firstName)
        addComponent(HorizontalLayout(Label("Last name"), tfLastName))
        personBinder.forField(tfLastName).withValidator(StringLengthValidator("Too short", 2, 100)).bind(Person::firstName)
        addComponent(HorizontalLayout(Label("Address"), tfAddress))
        addressBinder.forField(tfAddress).withValidator(StringLengthValidator("Too short", 2, 100)).bind(Address::streetAddress)
        addComponent(HorizontalLayout(Label("City"), tfCity))
        addressBinder.forField(tfCity).withValidator(StringLengthValidator("Too short", 2, 100)).bind(Address::city)
        addComponent(HorizontalLayout(Label("Phone"), tfPhone))
        phoneBinder.forField(tfPhone).withValidator(StringLengthValidator("Too short", 2, 100)).bind(PhoneNumber::number)

        val button = Button("print")
        button.addClickListener {
            Notification.show("Person:",
                    person.toString(),
                    Notification.Type.HUMANIZED_MESSAGE);
        }
        addComponent(button)
    }

    override fun enter(event: ViewChangeListener.ViewChangeEvent?) {
        person = Person()
    }
}

fun <BEAN, T> Binder.BindingBuilder<BEAN, T>.bind(prop: KMutableProperty<T>) {
    this.bind(
            ValueProvider { bean: BEAN -> prop.getter.call(bean) },
            Setter { bean: BEAN, v: T -> prop.setter.call(bean, v) })
}