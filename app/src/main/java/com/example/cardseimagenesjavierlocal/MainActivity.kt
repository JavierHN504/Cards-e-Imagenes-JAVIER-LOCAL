package com.example.cardseimagenesjavierlocal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.cardseimagenesjavierlocal.R
import com.example.cardseimagenesjavierlocal.ui.theme.CardsEImagenesJAVIERLOCALTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardsEImagenesJAVIERLOCALTheme {
                Scaffold(
                    topBar = { TopBarComponent()},
                    bottomBar = { BottomBarComponent()},

                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .padding(innerPadding)
                        .background(Color(0xFF212121))
                        .fillMaxSize()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
                            val imageResources =  listOf(
                                R.drawable.imagen1,
                                R.drawable.imagen2,
                                R.drawable.imagen3,
                                R.drawable.imagen4,
                                R.drawable.imagen5,
                                R.drawable.imagen6
                            )
                            LocalImageCard(imageResources)
                        }

                    }

                }
            }
        }
    }
}


@Composable
fun LocalImageCard(imageResources: List<Int>) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            imageResources.forEach {imageRes ->
                androidx.compose.foundation.Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(){
    TopAppBar({Text(stringResource(R.string.app_name), color = Color.White)},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.DarkGray
        )
    )
}

@Composable
fun BottomBarComponent(){
    BottomAppBar(containerColor = Color.DarkGray) {
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Home, contentDescription = "Inicio", tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Search, contentDescription = "Buscar", tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Agregar", tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Filled.PlayArrow, contentDescription = "Reproducir", tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Person, contentDescription = "Perfil", tint = Color.White)
        }

    }

}

