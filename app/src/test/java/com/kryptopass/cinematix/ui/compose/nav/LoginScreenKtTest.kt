package com.kryptopass.cinematix.ui.compose.nav

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.kryptopass.cinematix.ui.compose.movie.single.MovieScreen
import com.kryptopass.common.nav.NavRoutes
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class LoginScreenKtTest{

    @get:Rule
    val composeTestRule = createComposeRule() //create a rule which will apply to all Test in this class

    @Mock
    private lateinit var mockNavHostController: NavHostController



    //test for successful login
    @Test
    fun testSuccessfulLogin(){
        val mockAuth = mock(FirebaseAuth::class.java)
        val mockContext = mock(Context::class.java)
        val mockNavController = mock(NavHostController::class.java)

        `when`(mockAuth.signInWithEmailAndPassword(anyString(), anyString()))
            .thenAnswer { invocation ->
                val listener = invocation.getArgument<OnCompleteListener<Any>>(1)
                val task = mock(Task::class.java)
                `when`(task.isSuccessful).thenReturn(true)
                listener.onComplete(task as Task<Any>)
                task
            }

        signInWithEmailAndPassword("test@example.com", "password", mockContext, mockNavController)

        verify(mockNavController).navigate(anyString())
//        verify(mockContext).makeText(mockContext, "Success", Toast.LENGTH_SHORT)
    }

    //test for failed login
    @Test
    fun testFailedLogin(){

    }

}