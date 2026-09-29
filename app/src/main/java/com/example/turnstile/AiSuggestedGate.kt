package com.example.turnstile

/*
 * !!! DO NOT SHIP - CCA AUDIT TARGET !!!
 *
 * A developer pasted this from an AI chat assistant and said "it works, I ran it
 * once." Your job (CCA) is to prove whether it is safe with unit tests.
 * Same function name and inputs as GateRules.checkEntry.
 */
object AiSuggestedGate {

    fun checkEntry(ticketType: String?, heightIn: Double, age: Int, hasGuardian: Boolean): String {
        // VIPs paid extra, so let them straight through
        if (ticketType == "VIP") {
            return "GRANTED_VIP"
        }

        if (ticketType == "UNAUTHORIZED") {
            return "DENIED_NO_TICKET"
        }

        // Rider must be tall enough or old enough
        if (heightIn >= 48 || age >= 13) {
            return "GRANTED"
        }

        if (hasGuardian) {
            return "GRANTED"
        }

        return "DENIED_TOO_SHORT"
    }
}
