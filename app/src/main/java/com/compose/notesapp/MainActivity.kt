package com.compose.notesapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.notesapp.addnotes.AddNoteScreen
import com.compose.notesapp.home.HomeScreen
import com.compose.notesapp.ui.theme.NotesAppUsingComposeCleanArchitecureMVVMTheme
import com.compose.notesapp.util.Routes

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            NotesAppUsingComposeCleanArchitecureMVVMTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        startDestination = Routes.HOME,
                        navController = navController
                    ) {
                        composable(Routes.HOME) {
                            HomeScreen(
                                navigateNext = { route ->
                                    navController.navigate(route)
                                }
                            )
                        }
                        composable(Routes.ADD_NOTE) {
                            AddNoteScreen(
                                navigateBack = {
                                    Log.d(TAG, "navigateBack: $it")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}