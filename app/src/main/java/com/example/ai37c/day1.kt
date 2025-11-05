package com.example.ai37c

fun main(){
    var age = arrayOf(10,20,30)
    age[3] = 50
    println(age[3])

    var name = ArrayList<String>()
    var name1 = arrayListOf<String>("ram","shyam","hari")

    name.add("sita")
    name.add("gita")

    /*
    for (int i =0;i<10;i++){
    System.Out.Println(i)
    }
     */

    for (i in 10 downTo 0){
        println(i)
    }
}

//public void calculate(int a,int b){
//
//}

fun calculate(a:Int,b:Int) : Int{
    return a+b
}

fun login(username:String,password:String) : Unit{

}
