package com.example.turnstile

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

/*
 * CCA - Security & Safety Test Suite (Sprint 2, Story 4)
 * Run: click the green arrow next to the class name.
 *
 * DAY 1: you are auditing the AI-suggested code. check() below points at AiSuggestedGate.
 *        Every FAILED test is a bug you found - write each one up as a GitHub issue.
 * DAY 2: change AiSuggestedGate to GateRules inside check() and re-run against your
 *        team's real code. The goal is all green.
 * HOW TO FINISH A TODO TEST: Delete the @Ignore("TODO") line, then write ONE assertEquals line copying the pattern from the examples.
 */
class CcaSecurityTest {

    // The ONE line you change on Day 2:
    private fun check(ticket: String?, height: Double, age: Int, guardian: Boolean) =
        AiSuggestedGate.checkEntry(ticket, height, age, guardian)

    // ---------- Safety rules nobody can bypass ----------

    @Test
    fun c1_vipCannotSkipHeightRule() {
        assertEquals("DENIED_TOO_SHORT", check("VIP", 40.0, 30, false))
    }

    @Test
    fun c2_tallKidWithoutGuardianIsDenied() {
        // The AND/OR trap from Spot the Slop Lab 1
        assertEquals("DENIED_NEEDS_GUARDIAN", check("PATRON", 60.0, 10, false))
    }

    @Ignore("TODO")
    @Test
    fun c3_shortTeenagerIsDenied() {
        // The other half of the AND/OR trap
        // TODO (C3): ticket "PATRON", height 45.0, age 15, guardian false  ->  expect "DENIED_TOO_SHORT"
    }

    @Ignore("TODO")
    @Test
    fun c4_guardianCannotOverrideHeight() {
        // TODO (C4): ticket "PATRON", height 40.0, age 8, guardian true  ->  expect "DENIED_TOO_SHORT"
    }

    @Ignore("TODO")
    @Test
    fun c5_unauthorizedWithGuardianStillDenied() {
        // TODO (C5): ticket "UNAUTHORIZED", height 60.0, age 30, guardian true  ->  expect "DENIED_NO_TICKET"
    }

    // ---------- Bad or tampered ticket data ----------

    @Ignore("TODO")
    @Test
    fun c6_blankTicketIsDenied() {
        // TODO (C6): ticket "", height 60.0, age 30, guardian false  ->  expect "DENIED_NO_TICKET"
    }

    @Ignore("TODO")
    @Test
    fun c7_missingTicketIsDenied() {
        // TODO (C7): ticket null, height 60.0, age 30, guardian false  ->  expect "DENIED_NO_TICKET"
    }

    @Ignore("TODO")
    @Test
    fun c8_lowercaseTicketIsNotARealCode() {
        // TODO (C8): ticket "vip", height 60.0, age 30, guardian false  ->  expect "DENIED_NO_TICKET"
    }

    // ---------- Impossible measurements ----------

    @Ignore("TODO")
    @Test
    fun c9_negativeHeightIsInvalid() {
        // TODO (C9): ticket "PATRON", height -5.0, age 30, guardian false  ->  expect "DENIED_INVALID"
    }

    @Ignore("TODO")
    @Test
    fun c10_zeroHeightIsInvalid() {
        // TODO (C10): ticket "PATRON", height 0.0, age 30, guardian false  ->  expect "DENIED_INVALID"
    }

    @Ignore("TODO")
    @Test
    fun c11_giantHeightIsInvalid() {
        // TODO (C11): ticket "PATRON", height 500.0, age 30, guardian false  ->  expect "DENIED_INVALID"
    }

    @Ignore("TODO")
    @Test
    fun c12_negativeAgeIsInvalid() {
        // TODO (C12): ticket "PATRON", height 60.0, age -1, guardian false  ->  expect "DENIED_INVALID"
    }

    @Ignore("TODO")
    @Test
    fun c13_impossibleAgeIsInvalid() {
        // TODO (C13): ticket "PATRON", height 60.0, age 999, guardian false  ->  expect "DENIED_INVALID"
    }

    // ---------- Analytics integrity (DAY 2 - uses your team's real gate) ----------

    @Ignore("TODO")
    @Test
    fun c14_invalidScanCountsAsDeniedNotGranted() {
        val gate = TurnstileGate()
        gate.scan("PATRON", -5.0, 30, false)
        // TODO (C14, Day 2): assert granted is 0 and denied is 1
    }

}
