package com.dimarco.hourstacker

import java.util.*

class User {
    private var id: Int = 0
    var name: String = ""
    var birthday: String? = null


    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, birthday: String) {
        this.name = name
        this.birthday = birthday
    }

}