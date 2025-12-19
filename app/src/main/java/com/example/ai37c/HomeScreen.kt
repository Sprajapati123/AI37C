package com.example.ai37c

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ai37c.repository.ProductRepoImpl
import com.example.ai37c.viewmodel.ProductViewModel

@Composable
fun HomeScreen() {

    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }

    LaunchedEffect(Unit) {
        productViewModel.getAllProduct()
    }

    val allProducts = productViewModel.allProducts.observeAsState(initial = emptyList())
    val loading = productViewModel.loading.observeAsState(initial = false)

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        items(allProducts.value!!.size){index->
            var data = allProducts.value!![index]
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(data.name)
                    Text(data.price.toString())
                    Text(data.desc)
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Edit,contentDescription = null)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Delete,contentDescription = null)
                    }
                }
            }
        }
    }
}