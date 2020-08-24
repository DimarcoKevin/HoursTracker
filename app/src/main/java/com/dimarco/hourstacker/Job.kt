package com.dimarco.hourstacker

class Job {
    var id: Int? = null
    var companyName: String? = null
    var title: String? = null
    var wage: Double? = null

    constructor(id: Int, wage: Double) {
        this.id = id
        this.wage = wage
    }

    constructor(id: Int, companyName: String, title: String, wage: Double) {
        this.id = id
        this.companyName = companyName
        this.title = title
        this.wage = wage
    }
}