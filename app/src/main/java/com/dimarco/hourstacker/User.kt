package com.dimarco.hourstacker

import java.util.*

class User {
    private var id: Int = 0
    private var name: String = ""
    private var birthday: Date? = null


    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, birthday: Date) {
        this.name = name
        this.birthday = birthday
    }

}