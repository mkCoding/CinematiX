package com.kryptopass.cinematix.ui.compose.nav

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class LoginScreenKtTest{

    @get:Rule
    val composeTestRule = createComposeRule() //create a rule which will apply to all Test in this class

    @Mock
    private lateinit var mockNavHostController: NavHostController

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    //test for successful login
    @Test
    fun testSuccessfulLogin(){

    }

    //test for failed login
    @Test
    fun testFailedLogin(){

    }

    @Test
    fun testNavigationAfterSuccessLogin(){

    }
}