package com.example.ai37c.model

data class ProductModel(
    var productId : String = "",
    var name : String = "",
    var price : Double = 0.0,
    var desc : String = "",
    var categoryId:String = "",
    //9808222222
){
    fun toMap() : Map<String,Any?>{
        return mapOf(
            "name" to name,
            "price" to price,
            "desc" to desc,
            "categoryId" to categoryId,
        )
    }
}


