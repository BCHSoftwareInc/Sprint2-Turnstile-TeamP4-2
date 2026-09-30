package com.example.turnstile

/*
 * BCH Software Inc. | Sprint 2 - Apex Security Turnstile   (SE - Story 1)
 * Client: Apex Entertainment - "The Vortex" coaster
 *
 * checkEntry() is the decision engine. It has NO Compose or Android code in it -
 * it takes facts in and hands a result code back. That is what makes it
 * testable with a local unit test, just like calculateTip() in the Tip Time
 * codelab. (QA and CCA are writing tests against it RIGHT NOW.)
 *
 * Result codes (exact strings - tests compare them, spelling matters):
 *   "GRANTED"                Patron may ride
 *   "GRANTED_VIP"            VIP may ride (fast lane)
 *   "DENIED_NO_TICKET"       ticket type is UNAUTHORIZED, missing (null), or unknown
 *   "DENIED_INVALID"         height or age is impossible (bad scan)
 *   "DENIED_TOO_SHORT"       under 48 inches - applies to VIPs too
 *   "DENIED_NEEDS_GUARDIAN"  under 13 with no guardian present
 */
object GateRules {

    const val MIN_HEIGHT_IN = 48.0
    const val MIN_SOLO_AGE = 13
    const val MAX_HEIGHT_IN = 96.0
    const val MAX_AGE = 120

    fun checkEntry(ticketType: String?, heightIn: Double, age: Int, hasGuardian: Boolean): String {
        // Check the rules IN THIS ORDER. The first rule that matches wins - return right away.
        //val result = ""
        // TODO Rule 1: if ticketType is not "PATRON" and not "VIP" -> return "DENIED_NO_TICKET"
        if (ticketType != "PATRON" && ticketType != "VIP") {
            return "DENIED_NO_TICKET"
        }
        // TODO Rule 2: if heightIn <= 0, or heightIn > MAX_HEIGHT_IN,
        //              or age < 0, or age > MAX_AGE            -> return "DENIED_INVALID"
        if (heightIn <= 0 || heightIn > MAX_HEIGHT_IN || age < 0 || age > MAX_AGE) {
            return "DENIED_INVALID"
        }
        // TODO Rule 3: if heightIn < MIN_HEIGHT_IN              -> return "DENIED_TOO_SHORT"
        //              (VIPs are NOT exempt - this is a physical safety rule)
        if (heightIn < MIN_HEIGHT_IN) {
            return "DENIED_TOO_SHORT"
        }
        // TODO Rule 4: if age < MIN_SOLO_AGE AND there is no guardian -> return "DENIED_NEEDS_GUARDIAN"
        if (age < MIN_SOLO_AGE && !hasGuardian) {
            return "DENIED_NEEDS_GUARDIAN"
        }
        // TODO Rule 5: if ticketType is "VIP" -> return "GRANTED_VIP", otherwise return "GRANTED"
        if (ticketType == "VIP") {
            return "GRANTED_VIP"
        } else {
            return "GRANTED"
        }
    }

    fun isGranted(resultCode: String): Boolean = resultCode.startsWith("GRANTED")
}
