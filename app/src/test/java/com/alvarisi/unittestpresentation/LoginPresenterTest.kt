package com.alvarisi.unittestpresentation

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LoginPresenterTest {
    private val loginView = mock<LoginView>()
    lateinit var presenter: LoginPresenter

    @BeforeAll
    fun `set up`() {
        presenter = LoginPresenter(loginView)
    }

    @Nested
    @DisplayName("Given inserted email id")
    inner class EmailId{
        private val validEmailId = "alvarisi01@gmail.com"
        private val invalidEmailId = "alvarisi01gmail.com"

        @Test
        @DisplayName("When email id is invalid, then show error")
        fun whenEmailIsInvalid_showErrorMessage(){
            presenter.onEmailTextChanged(invalidEmailId)
            verify(loginView).showEmailError()
        }

        @Test
        @DisplayName("When email id is invalid, then make button disable")
        fun whenEmailIsInvalid_disableButton(){
            presenter.onEmailTextChanged(invalidEmailId)
            verify(loginView).disableSubmitButton()
        }

        @Test
        @DisplayName("When email id is valid, then remove error")
        fun whenEmailIsValid_removeErrorMessages(){
            presenter.onEmailTextChanged(validEmailId)
            verify(loginView).removeEmailError()
        }

        @Nested
        @DisplayName("Child 2")
        inner class AnoterTest{
            @Test
            @DisplayName("Child 2 Test")
            fun whenCalled_isFine(){
                assert(true)
            }
        }
    }

}