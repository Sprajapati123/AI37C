package com.example.ai37c

import android.app.Activity
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai37c.ui.theme.AI37CTheme
import com.example.ai37c.ui.theme.Blue
import com.example.ai37c.ui.theme.White

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashboardBody()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardBody() {
    val context = LocalContext.current
    val activity = context as Activity

//    val email = activity.intent.getStringExtra("email")
//    val password = activity.intent.getStringExtra("password")

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = White,
                    actionIconContentColor = White,
                    containerColor = Blue,
                    navigationIconContentColor = White
                ),
                title = {
                    Text("Ecommerce")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Image(painter = painterResource(R.drawable.face), contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(R.drawable.baseline_more_horiz_24), contentDescription = null)
                    }
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(R.drawable.baseline_visibility_off_24), contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

//            Text("Email: $email")
//            Text("Password: $password")
        }
    }
}