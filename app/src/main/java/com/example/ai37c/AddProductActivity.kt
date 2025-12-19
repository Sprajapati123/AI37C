package com.example.ai37c

import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai37c.model.ProductModel
import com.example.ai37c.repository.ProductRepoImpl
import com.example.ai37c.ui.theme.AI37CTheme
import com.example.ai37c.viewmodel.ProductViewModel

class AddProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AddProductBody()
        }
    }
}

@Composable
fun AddProductBody() {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }

    val context = LocalContext.current

    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }
    Scaffold { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            item {
                Spacer(modifier = Modifier.height(50.dp))
                OutlinedTextField(value = name, onValueChange = { name = it })
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(value = price, onValueChange = { price = it })
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(value = desc, onValueChange = { desc = it })
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    var model = ProductModel(
                        "",
                        name,
                        price.toDouble(),
                        desc,
                        ""
                    )
                    productViewModel.addProduct(model) { success, message ->
                        if (success) {
                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

                        }
                    }
                }) {
                    Text("Add product")
                }
            }
        }
    }
}

@Preview
@Composable
fun AddProductPreview() {
    AddProductBody()
}
