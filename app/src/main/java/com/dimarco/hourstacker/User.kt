package com.dimarco.hourstacker

class User {
    private var id: Int = 0
    private var name: String = ""
    private var birthday: String = ""


    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, birthday: String) {
        this.name = name
        this.birthday = birthday
    }

}