package com.example.ai37c.repository

import com.example.ai37c.model.ProductModel

interface ProductRepo {

//    {
//        success: true,
//        message: "product addded successfully"
//    }

    fun addProduct(model: ProductModel,callback:(Boolean,String)->Unit)

    fun updateProduct(model: ProductModel,callback: (Boolean, String) -> Unit)

    fun deleteProduct(productID:String,callback: (Boolean, String) -> Unit)

    fun getAllProduct(callback: (Boolean, String, List<ProductModel>?) -> Unit)

    fun getProductById(productID: String,callback: (Boolean, String, ProductModel?) -> Unit)

    fun getProductByCategory(categoryId:String,callback: (Boolean, String, List<ProductModel>?) -> Unit)
}