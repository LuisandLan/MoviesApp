package com.bignerdranch.android.moviesapp.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bignerdranch.android.moviesapp.MainViewModel
import com.bignerdranch.android.moviesapp.data.models.Movies


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    allMovies.forEach { Log.d("checkData", "ID: ${it.id} name:${it.name}") }
    Surface(modifier = Modifier
        .fillMaxSize()) {

        LazyColumn{
            items(allMovies.take(100)){ item ->
            MoviesItem(item = item)

            }
        }
    }
}

@Composable
fun MoviesItem(item: Movies) {
    Row(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(text = item.id.toString())
        Text(text = item.name)
    }

}
