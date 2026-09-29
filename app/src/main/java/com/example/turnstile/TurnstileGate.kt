package com.example.turnstile

/* Sprint 2 - Story 2 (SE): wraps the decision engine and keeps the day's analytics. */
class TurnstileGate {

    var grantedCount = 0
        private set
    var deniedCount = 0
        private set

    val totalScans: Int
        get() = 0 // TODO: grantedCount + deniedCount

    fun scan(ticketType: String?, heightIn: Double, age: Int, hasGuardian: Boolean): String {
        // TODO 1: val result = GateRules.checkEntry(...) with the four inputs
        // TODO 2: if GateRules.isGranted(result), grantedCount++ - otherwise deniedCount++
        // TODO 3: return result
        return "TODO"
    }
}
