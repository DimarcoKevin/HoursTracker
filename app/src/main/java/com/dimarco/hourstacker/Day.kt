package com.dimarco.hourstacker

import java.sql.Time

class Day {
    var id: Int? = null
    var punchInTime: Time? = null
    var punchOutTime: Time? = null

    constructor(id: Int, punchInTime: Time) {
        this.id = id
        this.punchInTime = punchInTime
    }

    constructor(id: Int, punchInTime: Time, punchOutTime: Time) {
        this.id = id
        this.punchInTime = punchInTime
        this.punchOutTime = punchOutTime
    }

}