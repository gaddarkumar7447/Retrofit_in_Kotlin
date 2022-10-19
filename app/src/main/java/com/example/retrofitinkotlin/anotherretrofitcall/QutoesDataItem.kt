package com.example.retrofitinkotlin.anotherretrofitcall

data class QutoesDataItem(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)