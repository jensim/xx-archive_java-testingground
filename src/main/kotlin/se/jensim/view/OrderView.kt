package se.jensim.view

import com.vaadin.data.Binder
import com.vaadin.data.Validator
import com.vaadin.data.ValueProvider
import com.vaadin.data.validator.StringLengthValidator
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.server.Setter
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.*
import se.jensim.domain.Person
import se.jensim.service.ValidatorService
import kotlin.reflect.KMutableProperty

@SpringView(name = OrderView.VIEW_NAME)
class OrderView : VerticalLayout(), View {

    companion object {
        const val VIEW_NAME = "order"
    }

    private lateinit var validatorService: ValidatorService

    private val tfFirstName = TextField()
    private val tfLastName = TextField()
    private val tfAddress = TextField()
    private val tfCity = TextField()
    private val tfPhone = TextField()

    private var person = Person("Per", "Son")
    private val personBinder = Binder<Person>(Person::class.java)

    init {
        personBinder.bean = person

        addComponent(HorizontalLayout(Label("First name"), tfFirstName))
        personBinder.forField(tfFirstName).withValidator(Person.StringLengthValidator(2, 100)).bind(Person::firstName)
        addComponent(HorizontalLayout(Label("Last name"), tfLastName))
        personBinder.forField(tfLastName).withValidator(Person.StringLengthValidator(2, 100)).bind(Person::lastName)
        addComponent(HorizontalLayout(Label("Address"), tfAddress))
        personBinder.forField(tfAddress).withValidator(Person.StringLengthValidator(2, 100)).bind(Person::streetAddress)
        addComponent(HorizontalLayout(Label("City"), tfCity))
        personBinder.forField(tfCity).withValidator(Person.StringLengthValidator(2, 100)).bind(Person::city)
        addComponent(HorizontalLayout(Label("Phone"), tfPhone))
        personBinder.forField(tfPhone).withValidator(Person.PhoneNumberValidator()).bind(Person::phoneNumber)

        val button = Button("print")
        button.addClickListener {
//            System.err.println("I am beeing called..!")
            Notification.show("Person:",
                    person.toString(),
                    Notification.Type.HUMANIZED_MESSAGE);
        }
        addComponent(button)
    }

    override fun enter(event: ViewChangeListener.ViewChangeEvent?) {
        person = Person()
    }

    fun <BEAN, T> Binder.BindingBuilder<BEAN, T>.bind(prop: KMutableProperty<T>) {
        this.bind(
                ValueProvider { bean: BEAN -> prop.getter.call(bean) },
                Setter { bean: BEAN, v: T -> prop.setter.call(bean, v) })
    }
}
