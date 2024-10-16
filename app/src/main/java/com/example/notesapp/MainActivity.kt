package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.ui.theme.NotesAppTheme
import com.example.notesapp.ui_layer.AddNoteScreen
import com.example.notesapp.ui_layer.NoteScreen
import com.example.notesapp.ui_layer.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                val viewmodel = hiltViewModel<NoteViewModel>()
                val state by viewmodel.state.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "note_screen"
                        ) {
                            composable("note_screen") {
                                NoteScreen(navController = navController, state = state, onEvent = viewmodel::onEvent)
                            }
                            composable("add_note_screen") {
                                AddNoteScreen(navHostController = navController, state = state, onEvent = viewmodel::onEvent)
                            }
                        }
                    }
                }
            }
        }
    }
}



