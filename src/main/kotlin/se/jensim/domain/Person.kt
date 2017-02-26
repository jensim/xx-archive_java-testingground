package se.jensim.domain

import com.vaadin.data.ValidationResult
import com.vaadin.data.Validator
import com.vaadin.data.ValueContext
import java.io.Serializable

data class Person(
        var id:String = "",
        var firstName: String = "",
        var lastName: String = "",
        var phoneNumber: String = "",
        var streetAddress: String = "",
        var city: String = ""
) : Serializable {
    class StringLengthValidator(val min: Int, val max: Int) : Validator<String> {
        override fun apply(value: String?, context: ValueContext?): ValidationResult {
            if (value == null) {
                return ValidationResult.error("null value")
            } else if (value.length < min) {
                return ValidationResult.error("Too short")
            } else if (value?.length > max) {
                return ValidationResult.error("Too long")
            } else {
                return ValidationResult.ok()
            }
        }
    }

    class PhoneNumberValidator : Validator<String> {
        override fun apply(value: String?, context: ValueContext?): ValidationResult {
            if (value == null) {
                return ValidationResult.error("Null value")
            } else if (value.matches(Regex("/^\\d+\\.\\d$|^\\d+$/"))) {
                return ValidationResult.ok()
            } else {
                return ValidationResult.error("Not a phone number format")
            }
        }
    }
}
