package com.example.consumeapijetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.consumeapijetpackcompose.ui.theme.ConsumeApiJetpackComposeTheme
import android.util.Log

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<PostsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConsumeApiJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    viewModel.getPosts()
                    Log.d("TAG","CANTIDAD DE POSTS ENCONTRADOS: " + viewModel._listaPosts.size)
                    viewModel._listaPosts.forEach{
                        Log.d("posts", it.toString())
                    }

                    Greeting("Android " + viewModel._listaPosts.size)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConsumeApiJetpackComposeTheme {
        Greeting("Android")
    }
}