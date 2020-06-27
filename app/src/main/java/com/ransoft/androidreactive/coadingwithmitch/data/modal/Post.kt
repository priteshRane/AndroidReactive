package com.ransoft.androidreactive.coadingwithmitch.data.modal

data class Post(
    var userId: Int? = null,
    var id: Int? = null,
    var title: String? = null,
    var body: String? = null,
    var comment: List<Comment>? = null
)